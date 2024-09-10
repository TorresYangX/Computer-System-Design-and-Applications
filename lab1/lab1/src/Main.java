import java.util.*;

// Class representing an Employee with name and age
class Employee implements Comparable<Employee> {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    // Overriding compareTo to sort employees by their names in alphabetical order
    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Employee{Name: " + name + ", Age: " + age + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

// Class representing the Employee Management System
class EmployeeManagementSystem {
    private Set<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new TreeSet<>();
    }

    // Method to add an employee
    public void addEmployee(String name, int age) {
        Employee employee = new Employee(name, age);
        if (employees.contains(employee)) {
            System.out.println("Employee " + name + " already exists.");
        } else {
            employees.add(employee);
            System.out.println("Added Employee: " + employee);
        }
    }

    // Method to delete an employee by name
    public void deleteEmployee(String name) {
        Employee toRemove = new Employee(name, 0); // Only name is needed for removal
        if (employees.remove(toRemove)) {
            System.out.println("Removed Employee: " + name);
        } else {
            System.out.println("Employee " + name + " not found.");
        }
    }

    // Method to print all employees in alphabetical order
    public void printAllEmployees() {
        System.out.println("Current Employees (sorted by name):");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        // Step 1: Add employees A, B, and C
        system.addEmployee("A", 25);
        system.addEmployee("B", 30);
        system.addEmployee("C", 22);

        // Step 2: Delete employee B
        system.deleteEmployee("B");

        // Step 3: Add employees A (again) and D
        system.addEmployee("A", 28); // This should show employee A already exists
        system.addEmployee("D", 35);

        // Step 4: Print all employees in alphabetical order
        system.printAllEmployees();
    }
}
