package fa.training.exercise2;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Employee employee = new Employee();
        Employee employee1 = new Employee();

        System.out.println("nhap thong tin nv dau tien ");
        employee.input(employee);

        System.out.println("nhap thong tin nv thu 2: ");
        employee1.input(employee1);

        System.out.println("Yearly Salary : ");
        System.out.printf("nv1: %.2f\n", employee.yearlySalary());
        System.out.printf("nv2: %.2f\n", employee1.yearlySalary());

        employee.raiseSalary(10);
        employee1.raiseSalary(10);
        System.out.println("Yearly Salary after raise 10% of: ");
        System.out.printf("The first employee: %.2f\n", employee.yearlySalary());
        System.out.printf("The second employee: %.2f", employee1.yearlySalary());
    }
}
