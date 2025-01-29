package Ass3;


import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeOperations {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Anirudh", "HR", 40000),
            new Employee(2, "Chandrahas", "Engineering", 45000),
            new Employee(3, "Kooresh", "Engineering", 43000),
            new Employee(4, "Pavan", "Sales", 45000),
            new Employee(5, "Varun", "HR", 48000),
            new Employee(6, "Dwarak", "Engineering", 44500)
        );

        // 1. Find Employee with Highest Salary
        employees.stream()
                .max(Comparator.comparingDouble(e -> e.salary))
                .ifPresent(e -> System.out.println("Employee with Highest Salary: " + e));

        // 2. Filter Employees with Salary Greater Than 5000
        System.out.println("Employees with Salary > 5000:");
        employees.stream()
                .filter(e -> e.salary > 5000)
                .forEach(System.out::println);

        // 3. Get Employee Names and Salaries
        System.out.println("Employee Names and Salaries:");
        employees.stream()
                .map(e -> e.name + " - " + e.salary)
                .forEach(System.out::println);

        // 4. Count Employees
        long count = employees.stream().count();
        System.out.println("Total Employees: " + count);

        // 5. Group Employees by Department
        System.out.println("Employees Grouped by Department:");
        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department));
        groupedByDept.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList);
        });

        // 6. Calculate Average Salary
        double averageSalary = employees.stream()
                .mapToDouble(e -> e.salary)
                .average()
                .orElse(0.0);
        System.out.println("Average Salary: " + averageSalary);

        // 7. Sort Employees by Salary
        System.out.println("Employees Sorted by Salary:");
        employees.stream()
                .sorted(Comparator.comparingDouble(e -> e.salary))
                .forEach(System.out::println);

        // 8. Find Employee with Second Highest Salary
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(e -> System.out.println("Second Highest Salary: " + e));

        // 9. Partition Employees by Salary Threshold
        System.out.println("Partition Employees by Salary > 5000:");
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.salary > 5000));
        partitioned.forEach((key, empList) -> {
            System.out.println((key ? "Above" : "Below") + " 5000: " + empList);
        });

        // 10. Find Employee with Longest Name
        employees.stream()
                .max(Comparator.comparingInt(e -> e.name.length()))
                .ifPresent(e -> System.out.println("Employee with Longest Name: " + e));

        // 11. Group Employees by Department and Calculate Average Salary
        System.out.println("Average Salary by Department:");
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.averagingDouble(e -> e.salary)));
        avgSalaryByDept.forEach((dept, avgSalary) -> {
            System.out.println(dept + ": " + avgSalary);
        });

        // 12. Find Top 3 Highest Paid Employees
        System.out.println("Top 3 Highest Paid Employees:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        // 13. Calculate Total Salary of All Employees Using Reduce
        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("Total Salary of All Employees: " + totalSalary);
    }
}
