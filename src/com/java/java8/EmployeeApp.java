package com.java.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.sound.midi.Soundbank;


public class EmployeeApp {

	public static void main(String[] args) {
		
		List<Employee> emp = Arrays.asList(new Employee(28, "John", 50000, "HR", "Male", 2014),
				new Employee(26, "Roma", 51000, "Tech", "Female", 2015),
				new Employee(31, "Mathew", 60000, "HR", "Male", 2017),
				new Employee(29, "John", 89000, "Ops", "Male", 2014),
				new Employee(24, "Linda", 3000, "HR", "Female", 2016),
				new Employee(26, "Michel", 95000, "Tech", "Male", 2013),
				new Employee(37, "Ram", 48000, "Tech", "Male", 2014),
				new Employee(29, "Agnes", 73000, "Ops", "Female", 2017),
				new Employee(30, "Jessica", 65000, "Ops", "Female", 2013),
				new Employee(31, "Julie", 56000, "Ops", "Female", 2017),
				new Employee(21, "xiaodong", 50600, "Ops", "Male", 2019),
				new Employee(32, "Liping", 50300, "Tech", "Female", 2013),
				new Employee(23, "Garry", 40000, "Tech", "Male", 2014),
				new Employee(40, "Harry", 170708, "Tech", "Female", 2017));
		
System.out.println("LEVEL 1 – BASIC (Filtering, Mapping, Simple Aggregation)\n");


				System.out.println("\n1. List all distinct departments");
				List<String> allDept = emp.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
				System.out.println(allDept);

				System.out.println("\n2. Count total number of employees");
				long empCount = emp.stream().map(Employee::getName).count();
				System.out.println(empCount);

				System.out.println("\n3. Count of male and female employees");
				long maleCount = emp.stream().filter(e->e.getGender().equals("Male")).count();
				long femaleCount = emp.stream().filter(e->e.getGender().equals("Female")).count();
				System.out.println(maleCount+" , "+femaleCount);
				Map<String, Long> genderCount = emp.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
				System.out.println(genderCount);

				System.out.println("\n4. Employees who joined after 2015");
				List<String> nameEmp = emp.stream().filter(e->e.getYearOfjoining()>2015).map(Employee::getName).collect(Collectors.toList());
				System.out.println(nameEmp);

				System.out.println("\n5. Names of employees working in Tech department");
				List<String> nameEmpTechDept = emp.stream().filter(e->e.getDepartment().equals("Tech")).map(Employee::getName).collect(Collectors.toList());
				System.out.println(nameEmpTechDept);
				
				System.out.println("\n6. Check if any employee salary is greater than 1 lakh");
				boolean anyMatch = emp.stream().anyMatch(e->e.getSalary()>100000);
				System.out.println(anyMatch);

				System.out.println("\n7. Check if all employees are older than 18");
				boolean allMatch = emp.stream().allMatch(e->e.getAge()>18);
				System.out.println(allMatch);

				System.out.println("\n8. Find total salary of all employees");
				int totalSum = emp.stream().mapToInt(Employee::getSalary).sum();
				System.out.println(totalSum);

				System.out.println("\n9. Count employees whose name starts with 'J'");
				emp.stream().filter(e->e.getName().startsWith("J")).forEach(System.out::println);

				System.out.println("\n10. Convert employee list to Map (Name -> Salary)");
				Map<String, Integer> map = emp.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary,(oldVal,newVal)->newVal));
				System.out.println(map);
				
System.out.println("\nLEVEL 2 – INTERMEDIATE (Sorting, Min/Max, Grouping)\n");
				
				System.out.println("\n11. Highest paid employee overall");
				Employee highestPaidEmp = emp.stream()
												.sorted(Comparator.comparingInt(Employee::getSalary)
														.reversed())
															.findFirst()
																.get();
				System.out.println(highestPaidEmp.getName()+" : "+highestPaidEmp.getSalary());
				
				System.out.println("\n12. Second highest salary employee");
				Employee secondHighPaidEmp = emp.stream()
						.sorted(Comparator.comparingInt(Employee::getSalary)
								.reversed())
									.skip(1)
										.findFirst()
											.get();
				System.out.println(secondHighPaidEmp.getName()+" : "+secondHighPaidEmp.getSalary());

				System.out.println("\n13. Top 3 highest paid employees");
				emp.stream()
						.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
							.limit(3)
									.forEach(e->System.out.println(e.getName()+" : "+e.getSalary()));

				System.out.println("\n14. Youngest employee in the organization");
				Employee youngestEmployee = emp.stream()
						.sorted(Comparator.comparingInt(Employee::getAge))
							.findFirst()
								.get();
				System.out.println(youngestEmployee.getName()+" : "+youngestEmployee.getAge());
				Employee youngest =
				        emp.stream()
				           .min(Comparator.comparingInt(Employee::getAge))
				           .get();

				System.out.println(youngest.getName() + " : " + youngest.getAge());
				
				System.out.println("\n15. Oldest employee in the organization");
				Employee oldEmployee = emp.stream()
						.sorted(Comparator.comparingInt(Employee::getAge).reversed())
							.findFirst()
								.get();
				System.out.println(oldEmployee.getName());
				
				System.out.println("\n16. Count of employees in each department");
				emp.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
						.forEach((k,v)->System.out.println(k+"->"+v));

				System.out.println("\n17. Average salary of each department");
				emp.stream()
						.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingInt(Employee::getSalary)))
							.forEach((k,v)->System.out.println(k+" "+v));
						
				System.out.println("\n18. Total salary paid by each department");
				emp.stream()
						.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingInt(Employee::getSalary)))
							.forEach((k,v)->System.out.println(k+" "+v));

				System.out.println("\n19. Employees grouped by year of joining");
				Map<Integer, List<Employee>> empByYear = emp.stream()
						.collect(Collectors.groupingBy(Employee::getYearOfjoining));
				
				empByYear.forEach((year, list) ->
		        System.out.println(year + " -> " +
		                list.stream().map(Employee::getName).toList()));

				System.out.println("\n20. Sort employees by salary in descending order");
				emp.stream()
						.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
							.forEach(e ->
									System.out.println(e.getName() + " : " + e.getSalary()));
				
System.out.println("LEVEL 3 – ADVANCED (Nested Grouping, Partitioning, Complex Logic)\n");
				
				System.out.println("\n21. Highest salary in each department");
				Map<String, Optional<Employee>> mapEmp = emp.stream()
						.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
				mapEmp.forEach((k,v)->System.out.println(k+"-> "+v.get().getName()+":"+v.get().getSalary()));

				System.out.println("\n22. Lowest salary in each department");
				Map<String, Optional<Employee>> lowSalEachDept = emp.stream()
						.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparingInt(Employee::getSalary))));
				lowSalEachDept.forEach((k,v)->System.out.println(k+"-> "+v.get().getName()+":"+v.get().getSalary()));

				System.out.println("\n23. Department-wise gender count");
				Map<String, Map<String, Long>> departMentWiseGenderCount = emp.stream()
						.collect(Collectors.groupingBy(
								Employee::getDepartment,Collectors
									.groupingBy(Employee::getGender,Collectors.counting())));
				System.out.println(departMentWiseGenderCount);

				System.out.println("\n24. Average age of male and female employees");
				Map<String, Double> avergeAgeMap = emp.stream()
						.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
				System.out.println(avergeAgeMap);

				System.out.println("\n25. Department having highest average salary");
				emp.stream()
						.collect(Collectors.groupingBy
									(Employee::getDepartment,Collectors.averagingInt(Employee::getSalary)));

				System.out.println("\n26. Employees whose salary is greater than average salary");

				System.out.println("\n27. Partition employees by age greater than 30");
				Map<Boolean, List<Employee>> part = emp.stream()
						.collect(Collectors.partitioningBy(e->e.getAge()>30));
				List<Employee> greaterThan30 = part.get(true);
				System.out.println("greater than 30 "+greaterThan30);
				List<Employee> lessThan30 = part.get(false);
				System.out.println("less than 30 employees:"+lessThan30);

				System.out.println("\n28. Employee names grouped by department");
				emp.stream()
						.collect(Collectors.groupingBy(Employee::getDepartment))
							.forEach((dept,list)->{
								System.out.println(dept);
								list.stream().map(Employee::getName).collect(Collectors.toList());
							});

				System.out.println("\n29. Sort employees by department then by salary");
				emp.stream()
						.sorted(Comparator.comparing(Employee::getDepartment)
								.thenComparing(Employee::getSalary))
									.forEach((e->System.out.println(e.getDepartment()
										+"->"+e.getName()+":"+e.getSalary())));
							

				System.out.println("\n30. Count total number of employees using parallel stream");
				long totalEmp = emp.parallelStream().count();
				System.out.println(totalEmp);


		System.out.println("TOP 5 most frequently asked Stream questions in almost every interview");
		System.out.println("\n Find highest paid employee in each department");
		Map<String, Optional<Employee>> empl = emp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
		empl.forEach((dept,emps)-> System.out.println(dept+" = "+ emps.get().getName()+" -> "+emps.get().getSalary()));


	}
}
