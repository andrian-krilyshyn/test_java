package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    private String name;
    private List<Employee> employees =  new ArrayList<Employee>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employee.setId(UUID.randomUUID());
        try {
            employeeProcessing(employee);
            employees.add(employee);
        }catch (CompanyException e){
            e.printStackTrace();
        }
    }


    public void employeeProcessing(Employee employee) throws CompanyException {
        switch (employee.getPosition()) {
            case "Manager":
                if (getMangerCount() >= 4) {
                    throw new CompanyException("Too many managers!");
                }
                break;

            case "Tester", "HR":
                if (employee.getSalary() > 8000) {
                    throw new CompanyException("Salary exceeds limit!");
                }
                break;
        }
    }


    private int getMangerCount() {
        return (int) employees.stream()
                .filter(x -> x.getPosition().equalsIgnoreCase("Manager"))
                .count();
    }


    public void deleteEmployee(UUID id)  {
        Employee employee = getEmployee(id);
        try {
            if (employee.getPosition().equalsIgnoreCase("Manager")) {
                throw new CompanyException("Cannot delete Manager!");
            } else {
                employees.remove(employee);
            }
        }catch (CompanyException e){
            e.printStackTrace();
        }
    }

    public Employee getEmployee(UUID id) {
        return  employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Employee> filterEmployees(String filterBy, double value){
        return switch (filterBy.toLowerCase()) {
            case "salary" -> employees.stream()
                    .filter(employee -> employee.getSalary() > value)
                    .collect(Collectors.toList());
            case "age" -> employees.stream()
                    .filter(employee -> employee.getAge() > value)
                    .collect(Collectors.toList());
            default -> employees;
        };
    }
    public void upadateEmployee(UUID id, EmployeeDTO employeeDTO) throws CompanyException {
        Employee employee = getEmployee(id);
        if(getEmployee(id)==null){
            throw new CompanyException("Not found employee");
        }
        if (employeeDTO.getName() != null) {
            employee.setName(employeeDTO.getName());
        }

        if (employeeDTO.getPosition() != null) {
            employee.setPosition(employeeDTO.getPosition());
        }

        if (employeeDTO.getSalary() > 0) {
            employee.setSalary(employeeDTO.getSalary());
        }

        if (employeeDTO.getAge() > 0) {
            employee.setAge(employeeDTO.getAge());
        }
    }



    static class EmployeeNameComparetor implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    static class EmployeeAgeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge() - o2.getAge();
        }
    }
    static class EmployeeSalaryComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return (int) (o1.getSalary()-o2.getSalary());
        }
    }
}
