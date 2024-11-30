package org.example;

import java.util.Comparator;
import java.util.UUID;

public class Employee {
    private UUID id;
    private String name;
    private int age;
    private double salary;
    private String position;

    public Employee(UUID id, String name, int age, double salary, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public Employee( String name, int age, double salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getPosition() { return position; }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{\nid=" + id + ",\n name='" + name + "',\n age=" + age + ",\n salary=" + salary + ",\n position='" + position + "'\n}\n";
    }
}

