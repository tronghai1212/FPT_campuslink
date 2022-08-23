package fa.training.ex2;

import java.util.Scanner;

public class Employee {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;
    private int id;
    private long salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

     public Employee Input(){
        Employee employee = new Employee();
         System.out.print("Name: ");
         employee.setName(scanner.nextLine());
         System.out.print("ID: ");
         employee.setId(scanner.nextInt());
         System.out.print("Salary: ");
         employee.setSalary(scanner.nextInt());
         scanner.nextLine();
         System.out.print("Line: ");
         employee.setAddress(scanner.nextLine());
         return employee;
     }

    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
