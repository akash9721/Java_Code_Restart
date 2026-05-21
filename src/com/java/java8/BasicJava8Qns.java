package com.java.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicJava8Qns {

    public static boolean checkAnagram(String s1,String s2){
        if(s1.length()!=s2.length())
            return false;
        // Assuming ASCII lowercase letters (a-z)
        int[] countFreq=new int[26];

        for(int i=0;i<s1.length();i++){
            countFreq[s1.charAt(i)-'a']++;
            countFreq[s2.charAt(i)-'a']--;
        }

        // If it is an anagram, all array indexes must return to 0
        for(int count:countFreq){
            if(count!=0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("\n1. Reverse String using Java 8");
        String str = "akash";
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println(reversed);

        System.out.println();
        String rev = str.chars()
                .mapToObj(ch -> (char) ch)
                .reduce("", (acc, curr) -> curr + acc, (s1, s2) -> s2 + s1);
        System.out.println(rev);

        System.out.println("\n2. Check String Palindrome using Java 8");
        String input = "naman";
        boolean equals = input.equals(new StringBuilder(input).reverse().toString());
        System.out.println(equals);

        System.out.println("\n3. Find Duplicate Elements in List using Streams");
        List<Integer> list = Arrays.asList(1,9,4,6,1,2,3,4,7,9);
        Set<Integer> set=new HashSet<>();
        list.stream().filter(n->!set.add(n)).forEach(System.out::println);

        System.out.println("\n4. Find Duplicate Characters in String");
        String str1 = "programming";
                    str1.chars()
                        .mapToObj(ch->(char)ch)
                                .collect(Collectors.groupingBy(ch->ch,Collectors.counting()))
                                        .entrySet()
                                                .stream()
                                                        .filter(ch->ch.getValue()>1)
                                                                .forEach(e-> System.out.print(e.getKey()+" "));

        System.out.println("\n5. Find First Non-Repeated Character in String");
        String str2 = "swiss";
        Character firstNonRepChar = str2.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(null);
        System.out.println(firstNonRepChar);

        System.out.println("\n6. Find Frequency of Characters in String");
        String str3 = "java";
                    str3.chars()
                        .mapToObj(ch->(char)ch)
                                .collect(Collectors.groupingBy(ch->ch,Collectors.counting()))
                                        .forEach((k,v)-> System.out.println(k+" -> "+v));

        System.out.println("\n7. Find Frequency of Words in String");
        String words = "java spring java boot microservices spring java";
        Arrays.stream(words.split("\\s+"))
                        .collect(Collectors.groupingBy(word->word,Collectors.counting()))
                                .forEach((k,v)-> System.out.println(k+" -> "+v));

        System.out.println("\n8. Check Two Strings are Anagram");
        String s1 = "listen";
        String s2 = "silent";
        boolean isAnagram = s1.length() == s2.length() &&
                Arrays.equals(s1.chars().sorted().toArray(), s2.chars().sorted().toArray());
        System.out.println(isAnagram);
        System.out.println(checkAnagram(s1,s2)?"are anagram":"are not anagram");

        System.out.println("\n9. Remove Duplicate Elements from List");
        List<Integer> list1 = Arrays.asList(1,2,3,2,4,1,5);
        List<Integer> unique = list1.stream().distinct().collect(Collectors.toList());
        System.out.println(unique);

        List<Integer> uniqueEle=new ArrayList<>();
        for(Integer ele:list1){
            if (!uniqueEle.contains(ele)){
                uniqueEle.add(ele);
            }
        }
        System.out.println(uniqueEle);

        System.out.println("\n10. Find Second Highest Number in List");
        List<Integer> list2 = Arrays.asList(10,20,40,30,50,5);
        Integer secondHighest = list2.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow(null);
        System.out.println(secondHighest);

        System.out.println("\n11. Find Highest Number in List");
        Integer firstHighest = list2.stream()
                .sorted(Comparator.reverseOrder()).findFirst().orElseThrow(null);
        System.out.println(firstHighest);

        System.out.println("OR");
        int maxNum = list2.stream().mapToInt(ele -> ele).max().getAsInt();
        System.out.println(maxNum);

        System.out.println("OR");
        Integer highest = list2.stream().max(Comparator.naturalOrder()).orElseThrow(() -> new RuntimeException("List is empty"));
        System.out.println(highest);

        System.out.println("\n12. Find Minimum Number in List");
        Integer lowest = list2.stream().min(Comparator.naturalOrder()).orElseThrow(() -> new RuntimeException("List is empty"));
        System.out.println(lowest);

        System.out.println("OR");
        Integer minValue = list2.stream().sorted().findFirst().orElseThrow(() -> new RuntimeException("List is empty"));
        System.out.println(minValue);

        System.out.println("\n13. Find Sum of Numbers using reduce()");
        Integer sum = list2.stream()
                .reduce(0, (acc, curr) -> curr + acc);
        System.out.println(sum);

        System.out.println("OR");
        int sum1 = list2.stream().mapToInt(ele -> ele).sum();
        System.out.println(sum1);

        System.out.println("\n14. Find Average of Numbers using Streams");
        double avg = list2.stream().mapToInt(ele -> ele).average().getAsDouble();
        System.out.println(avg);

        System.out.println("\n15. Filter Even Numbers from List");
        List<Integer> even = list2.stream().filter(ele -> ele % 2 == 0).toList();
        System.out.println(even);

        System.out.println("\n16. Filter Odd Numbers from List");
        List<Integer> odd = list2.stream().filter(ele -> ele % 2!=0).toList();
        System.out.println(odd);

        System.out.println("\n17. Sort List in Ascending Order");
        List<Integer> sortedAsc = list2.stream().sorted().toList();
        System.out.println(sortedAsc);

        System.out.println("\n18. Sort List in Descending Order");
        List<Integer> sortDes = list2.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortDes);

        List<Employee1> emps = Arrays.asList(
                new Employee1("Amit", "IT", 85000, 28),
                new Employee1("Rahul", "HR", 60000, 32),
                new Employee1("Priya", "IT", 95000, 30),
                new Employee1("Sneha", "Finance", 85000, 26), // Same salary as Amit for multi-level sorting
                new Employee1("Amit", "Finance", 70000, 35),   // Same name, different dept/salary
                new Employee1("Vikram", "HR", 60000, 29),      // Same salary as Rahul
                new Employee1("Neha", "IT", 120000, 34),       // Highest salary
                new Employee1("Rohan", "Marketing", 55000, 24)
        );

        System.out.println("\n19. Sort Employees by Salary");
        List<Employee1> sortedBySalry = emps.stream()
                .sorted(Comparator.comparingDouble(Employee1::getSalary)).toList();
        System.out.println(sortedBySalry);

        System.out.println("\n20. Multi-Level Sorting using Comparator");
        List<Employee1> sortedByAge = emps.stream()
                .sorted(Comparator.comparingInt(Employee1::getAge).thenComparing(Employee1::getName)).toList();
        System.out.println(sortedByAge);

        System.out.println("\n21. Find Highest Salary Employee1");
        Employee1 data = emps.stream()
                .max(Comparator.comparingDouble(Employee1::getSalary)).get();
        System.out.println(data.getName()+" "+data.getSalary());

        System.out.println("\n22. Find Second Highest Salary Employee1");
        Employee1 secondHight = emps.stream()
                .sorted(Comparator.comparingDouble(Employee1::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElseThrow(null);
        System.out.println(secondHight.getName()+" "+secondHight.getSalary());

        System.out.println("\n23. Group Employees by Department");
        emps.stream()
                        .collect(Collectors.groupingBy(Employee1::getDepartment))
                                .forEach((dept,empLists)->
                                        System.out.println(dept+" -> "+
                                                empLists.stream().map(Employee1::getName).toList()));

        System.out.println("\n24. Count Employee1s in Each Department");
        emps.stream()
                        .collect(Collectors.groupingBy(Employee1::getDepartment,Collectors.counting()))
                                .forEach((k,v)-> System.out.println(k+" ->= "+v));

        System.out.println("\n25. Convert List to Map using Streams");
        emps.stream()
                        .collect(Collectors.toMap(Employee1::getName,Employee1::getAge,(old,curr)->curr))
                                .forEach((k,v)-> System.out.println(k+" "+v));


        List<Integer> listA = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listB = Arrays.asList(4, 5, 6, 7, 8);
        System.out.println("\n26. Find Common Elements Between Two Lists");
        List<Integer> commonEle = listA.stream()
                .filter(listB::contains).toList();
        System.out.println(commonEle);

        System.out.println("\n27. Merge Two Lists using Stream.concat()");
        List<Integer> mergedList = Stream.concat(listA.stream(), listB.stream()).collect(Collectors.toList());
        System.out.println(mergedList);

        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2, 11), Arrays.asList(3, 4, 22, 44), Arrays.asList(5, 6));
        System.out.println("\n28. Flatten Nested List using flatMap()");
        System.out.println(nestedList);
        List<Integer> finalList = nestedList.stream()
                .flatMap(ele -> ele.stream()).toList();
        System.out.println(finalList);

        System.out.println("\n29. Difference Between map() and flatMap()");

        System.out.println("\n30. Difference Between Stream and Parallel Stream");
    }
}
