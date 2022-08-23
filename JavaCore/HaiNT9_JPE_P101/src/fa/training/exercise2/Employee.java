package fa.training.exercise2;

import java.util.Scanner;

public class Employee {

    Scanner scanner = new Scanner(System.in);

    protected String firstName;
    protected String lastName;
    protected double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            this.salary = 0.0;
        }
    }

    public double yearlySalary() {
        return this.salary * 12;
    }

    public void raiseSalary(double percent) {
        this.setSalary(this.salary * (100 + percent) / 100);
    }

    public void input(Employee employee){
        System.out.print("First name: ");
        employee.firstName = scanner.next();
        System.out.print("Last name: ");
        employee.lastName = scanner.next();
        System.out.print("Monthly Salary: ");
        employee.salary = scanner.nextDouble();
    }
}
