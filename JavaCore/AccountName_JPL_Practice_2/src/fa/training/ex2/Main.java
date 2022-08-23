package fa.training.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> listEmployee = new ArrayList<>();
        Employee employee = new Employee();
        Department department = new Department("Information Technology", "Hoa Lac");
        int n;
        System.out.print("so nhan vien: ");
        n = scanner.nextInt();
        for (int i = 0; i<n; i++){
            System.out.println("Nhap vao nhan vien thu "+(i+1));
            listEmployee.add(employee.Input());
            department.setListEmployee(listEmployee);
        }
        System.out.print(department.toString());

    }
}
