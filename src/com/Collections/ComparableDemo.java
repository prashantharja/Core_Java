package com.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee> {

	int id;
	String name;
	int salary;

	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee emp) {
		return Integer.compare(this.id, emp.id);
	}

	@Override
	public String toString() {
		return "{id=" + id + ", name='" + name + "', salary=" + salary + "}";
	}
}

public class ComparableDemo {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(103, "Charlie", 75000));
		employees.add(new Employee(101, "Bob", 90000));
		employees.add(new Employee(102, "Alice", 60000));

		System.out.println("--- ORIGINAL LIST (Insertion Order) ---");
		printList(employees);

		// ==========================================
		// SCENARIO A: Using COMPARABLE (Natural Order)
		// ==========================================
		// Because Employee implements Comparable, Collections.sort knows exactly what
		// to do.
		Collections.sort(employees);

		System.out.println("\n--- AFTER COMPARABLE (Sorted by ID) ---");
		printList(employees);

		// ==========================================
		// SCENARIO B: Using COMPARATOR (Custom Order 1)
		// ==========================================
		// We want to sort by Name, but we can't change the compareTo method inside
		// Employee!
		// So, we create an external rule (Comparator).

		Comparator<Employee> nameSorter = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.name.compareTo(e2.name); // Sorting alphabetically
			}
		};

		// We pass the list AND the custom rule
		Collections.sort(employees, nameSorter);
		// Modern alternative: employees.sort(nameSorter);

		System.out.println("\n--- AFTER COMPARATOR 1 (Sorted by Name) ---");
		printList(employees);

		// ==========================================
		// SCENARIO C: Modern Java 8 COMPARATOR (Custom Order 2)
		// ==========================================
		// Senior developers don't write the bulky code above anymore.
		// We use Lambdas and factory methods to sort by Salary (Descending).

		Comparator<Employee> salarySorterDesc = Comparator.comparingDouble((Employee e) -> e.salary)
				.reversed();

		employees.sort(salarySorterDesc);

		System.out.println("\n--- AFTER COMPARATOR 2 (Sorted by Salary Descending) ---");
		printList(employees);

	}

	private static void printList(List<Employee> list) {
		for (Employee e : list) {
			System.out.println(e);
		}

	}
}
