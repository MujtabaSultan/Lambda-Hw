package com.hw.labda;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private List<Employee> employees = Arrays.asList(
            new Employee("Bezos, Jeff", LocalDate.of(2004, 4, 2), 68_109.00, "Male"),
            new Employee("Sheryl Sandberg", LocalDate.of(2014, 7, 1), 87_846.00, "Female"),
            new Employee("Buffet, Warren", LocalDate.of(2011, 7, 23), 95_035.00, "Male"),
            new Employee("Susan Wojcick", LocalDate.of(2015, 6, 1), 37_210.00, "Female"),
            new Employee("Zuckerberg, Mark", LocalDate.of(2016, 5, 12), 48_450.00, "Male"),
            new Employee("Brin, Sergey", LocalDate.of(2016, 8, 5), 74_416.00, "Male")
    );

    private <E> void printList(List<E> list) {
        // TODO Print out all the elements in the supplied list:
        list.forEach(System.out::println);


    }

    public void getEmployeesOver50k() {
        // TODO Print a list of all employees that earn $50,000 or more
        List<Employee> employees = null;
        employees=this.employees.stream().filter(p->p.getSalary()>50000).toList();
        printList(employees);
    }

    public void getEmployeeNamesHiredAfter2012() {
        // TODO Print a list of the names (not the Employee instances) of all employees who were hired on or after Jan. 1, 2012:
        // HINT: look it up for "LocalDate.of"
        List<String> employees =null;
         printList(this.employees.stream().filter(p->(p.getHireDate()).isAfter(LocalDate.of(2012,1,1))).toList());
    }

    public void getMaxSalary() {
        // TODO Print the maximum salary of all employees...
        double max = 0;
        System.out.println("Max:" + employees.stream().max(Comparator.comparing(p->p.getSalary())));
    }

    public void getMinSalary() {
        // TODO Print the minimum salary of all employees...
        double min = 0;
        System.out.println("Min:" + employees.stream().min(Comparator.comparing(p->p.getSalary())));
    }

    public void getAverageSalaries() {
        // TODO print the average salary of all Female and Male employees:
        double averageFemale = 0;
        double averageMale = 0;

        averageMale=employees.stream()
                .filter(p->p.getGender().equals("Male"))
                .map(p->p.getSalary())
                .reduce(0.0,(accum,curr)->accum+curr)/employees.stream().filter(p->p.getGender().equals("Male")).toList().size();

        averageFemale=employees.stream()
                .filter(p->p.getGender().equals("Female"))
                .map(p->p.getSalary())
                .reduce(0.0,(accum,curr)->accum+curr)/employees.stream().filter(p->p.getGender().equals("Female")).toList().size();

        System.out.println("Averages: Female:" + averageFemale);
        System.out.println("Averages: Male:" + averageMale);
    }

    public void getMaximumPaidEmployee() {
        // TODO use the reduce() operation to find the Employee instance of the employees list with the highest salary:
        Employee highest = null;
       highest = employees.stream().reduce((accum,curr)->curr.getSalary()>accum.getSalary()? curr:accum).orElseThrow();
        System.out.println(highest);
    }

    public static void main(String[] args) {
//
     Main me = new Main();
     me.printList(me.employees);
        me.getMaxSalary();
        me.getMinSalary();
        me.getAverageSalaries();
        me.getMaximumPaidEmployee();
        me.getEmployeeNamesHiredAfter2012();
        me.getEmployeesOver50k();


    }
}