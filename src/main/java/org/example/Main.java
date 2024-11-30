package org.example;


import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("NazarCompany");

        Employee employee1 = new Employee("Alice", 29, 5500.0, "Java Developer");
        Employee employee2 = new Employee("Bob", 35, 7000.0, "Team Lead");
        Employee employee3 = new Employee("Charlie", 28, 4500.0, "Tester");
        Employee employee4 = new Employee("David", 41, 2500.0, "Developer");
        Employee employee5 = new Employee("Eve", 38, 10000.0, "HR");
        Employee employee6 = new Employee("Frank", 30, 6500.0, "Java Developer");
        Employee employee7 = new Employee("Grace", 33, 6000.0, "Manager");
        Employee employee8 = new Employee("Hank", 40, 7500.0, "Manager");
        Employee employee9 = new Employee("Ivy", 26, 5000.0, "Frontend Developer");
        Employee employee10 = new Employee("Jack", 45, 7900.0, "Backend Developer");
        Employee employee11 = new Employee("Mary", 44, 7900.0, "Manager");
        Employee employee12 = new Employee("Ivan", 11, 7800.0, "Manager");
        Employee employee13 = new Employee("Oleh", 2, 100.0, "Manager");


        company.addEmployee(employee2);
        company.addEmployee(employee4);
        company.addEmployee(employee5);
        company.addEmployee(employee1);
        company.addEmployee(employee6);
        company.addEmployee(employee7);
        company.addEmployee(employee8);
        company.addEmployee(employee3);
        company.addEmployee(employee9);
        company.addEmployee(employee10);
        company.addEmployee(employee11);
        company.addEmployee(employee12);
        company.addEmployee(employee13);


        System.out.println("\n////////ID Check:");
        System.out.println(employee1);
        System.out.println("Employee Id: " + employee1.getId());

        System.out.println("\n////////Name sort:");
        company.getEmployees().forEach(employee -> System.out.print(employee.getName()+", "));
        System.out.println();
        company.getEmployees().sort(new Company.EmployeeNameComparetor());
        company.getEmployees().forEach(employee -> System.out.print(employee.getName()+", "));

        System.out.println("\n\n////////Age sort:");
        company.getEmployees().forEach(employee -> System.out.print(employee.getAge()+", "));
        System.out.println();
        company.getEmployees().sort(new Company.EmployeeAgeComparator());
        company.getEmployees().forEach(employee -> System.out.print(employee.getAge()+", "));

        System.out.println("\n\n////////Salary sort:");
        company.getEmployees().forEach(employee -> System.out.print(employee.getSalary()+", "));
        System.out.println();
        company.getEmployees().sort(new Company.EmployeeSalaryComparator());
        company.getEmployees().forEach(employee -> System.out.print(employee.getSalary()+", "));

        System.out.println("\n\n////////Salary more than 7k:");
        System.out.println(company.filterEmployees("salary", 7000));

        System.out.println("\n////////Age more than 40:");
        System.out.println(company.filterEmployees("age", 40));

        System.out.println("\n////////Delete employee(Manager");
        company.deleteEmployee(employee12.getId());
        System.out.println(company.getEmployee(employee12.getId()));

        System.out.println("\n////////Delete employee(not Manager");
        company.deleteEmployee(employee10.getId());
        System.out.println(company.getEmployee(employee10.getId()));

        System.out.println("\n////////Update employee");
        System.out.println("Employee original: " + company.getEmployee(employee1.getId()));
        try {
            company.upadateEmployee(employee1.getId(), new EmployeeDTO("Petro", 0, 10000,null));
        } catch (CompanyException e) {
            e.printStackTrace();
        }
        System.out.println("Employee updated: " + company.getEmployee(employee1.getId()));

    }
}
