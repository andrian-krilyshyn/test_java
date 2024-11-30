package org.example;

public class EmployeeDTO {

    private String name;
    private int age;
    private double salary;
    private String position;

    public EmployeeDTO(String name, int age, double salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }


}
