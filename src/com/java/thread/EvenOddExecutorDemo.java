package com.java.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class EvenOddTask {

    private int count = 1;
    private final int max = 20;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition evenCondition = lock.newCondition();
    private final Condition oddCondition = lock.newCondition();

    public void printOdd() {
        while (true) {
            lock.lock();
            try {
                while (count <= max && count % 2 == 0) {
                    oddCondition.await();
                }

                if (count > max) {
                    evenCondition.signal(); // wake even thread before exit
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " : " + count++);
                evenCondition.signal();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    public void printEven() {
        while (true) {
            lock.lock();
            try {
                while (count <= max && count % 2 != 0) {
                    evenCondition.await();
                }

                if (count > max) {
                    oddCondition.signal(); // wake odd thread before exit
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " : " + count++);
                oddCondition.signal();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }
}

public class EvenOddExecutorDemo {

    public static void main(String[] args) {

        EvenOddTask task = new EvenOddTask();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(task::printOdd);
        executor.submit(task::printEven);

        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}