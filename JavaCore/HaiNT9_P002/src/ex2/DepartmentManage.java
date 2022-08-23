package ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentManage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flag;
        List<Department> departmentList = new ArrayList<>();

        do {
            System.out.print("======Department MANAGEMENT SYSTEM======\n" +
                    "1. Create a Department\n" +
                    "2. Add an Employee to a Department\n" +
                    "3. Display Employee information\n" +
                    "4. Display Employees of an Department\n" +
                    "5. Search Employee\n" +
                    "6. Display All Department\n" +
                    "Please choose function you'd like to do:");

            int userChoose = scanner.nextInt();
            switch (userChoose) {
                case (1): {
                    Department department1 = new Department();
                    Boolean checkDepID = false;
                    System.out.print("Department ID: ");
                    department1.setId(scanner.next());
                    if (departmentList.isEmpty()) {
                        departmentList.add(department1);
                    } else {
                        for (Department department : departmentList) {
                            if (department1.getId().equals(department.getId())) {
                                checkDepID = true;
                            }
                        }
                        if (!checkDepID) {
                            departmentList.add(department1);
                        } else {
                            System.out.println("This Department exists");
                        }
                    }
                    break;
                }
                case (2): {
                    boolean checkSSN = false;
                    System.out.print("Enter Department ID: ");
                    String ID_entered = scanner.next();
                    for (Department department : departmentList) {
                        if (department.getId().equals(ID_entered)) {
                            System.out.print("Choose type of Employee (h/s): ");
                            String type = scanner.next();
                            switch (type) {
                                case "h": {
                                    Employee employee = new HourlyEmployee();
                                    employee.addEmployee();
                                    if (department.getEmployeeList().isEmpty()) {
                                        department.getEmployeeList().add(employee);
                                    } else {
                                        for (Employee employee1 : department.getEmployeeList()) {
                                            if (employee1.getSsn().equals(employee1.getSsn())) {
                                                checkSSN = true;
                                            }
                                        }
                                        if (checkSSN) {
                                            System.out.println("This SSN is already in this department\n");
                                        } else {
                                            department.getEmployeeList().add(employee);
                                        }
                                    }
                                    break;
                                }
                                case "s": {
                                    Employee employee2 = new SalesEmployee();
                                    employee2.addEmployee();
                                    if (department.getEmployeeList().isEmpty()) {
                                        department.getEmployeeList().add(employee2);
                                    } else {
                                        for (Employee employee : department.getEmployeeList()) {
                                            if (employee.getSsn().equals(employee2.getSsn())) {
                                                checkSSN = true;
                                            }
                                        }
                                        if (checkSSN) {
                                            System.out.println("This SSN is already in this department\n");
                                        } else {
                                            department.getEmployeeList().add(employee2);
                                        }
                                    }
                                    break;
                                }
                            }
                        } else {
                            System.out.println("This Department ID not exist\n Try again or create one");
                        }
                    }
                    break;
                }
                case (3): {
                    boolean checkDepartment = false;
                    boolean checkSSN = false;
                    int index = 0;
                    int indexE = 0;
                    System.out.print("Enter Department ID: ");
                    String ID_entered = scanner.next();
                    for (Department department : departmentList) {
                        if (ID_entered.equals(department.getId())) {
                            checkDepartment = true;
                            index = departmentList.indexOf(department);
                        }
                    }
                    if (checkDepartment) {
                        System.out.print("SSN: ");
                        String ssn_entered = scanner.next();
                        for (Employee e : departmentList.get(index).getEmployeeList()) {
                            if (e.getSsn().equals(ssn_entered)) {
                                checkSSN = true;
                                indexE = departmentList.get(index).getEmployeeList().indexOf(e);
                            }
                        }
                    } else {
                        System.out.println("Not exists this department");
                        break;
                    }
                    if (checkSSN) {
                        System.out.println(departmentList.get(index).getEmployeeList().get(indexE).toString());
                    } else {
                        System.out.println("Not exists this SSN in this department");
                    }
                    break;
                }
                case (4): {
                    boolean checkDepartment = false;
                    int index = 0;
                    int indexE = 0;
                    System.out.print("Enter Department ID: ");
                    String ID_entered = scanner.next();
                    for (Department department : departmentList) {
                        if (ID_entered.equals(department.getId())) {
                            checkDepartment = true;
                            index = departmentList.indexOf(department);
                        }
                    }
                    if (checkDepartment) {
                        System.out.println("HourlyEmployee: ");
                        for (Employee e : departmentList.get(index).getEmployeeList()) {
                            if (e instanceof HourlyEmployee) {
                                System.out.println(e.toString());
                            }
                        }
                        System.out.println("SalesEmployee: ");
                        for (Employee e : departmentList.get(index).getEmployeeList()) {
                            if (e instanceof SalesEmployee) {
                                System.out.println(e.toString());
                            }
                        }
                    } else {
                        System.out.println("Not exists this department");
                        break;
                    }
                    break;
                }

                case (5): {
                    System.out.print("a. Enter Department ID\n" +
                            "b. Enter Employee's name\n" +
                            "Please choose function you'd like to do: (a/b)");
                    String empSearch = scanner.next();
                    switch (empSearch) {
                        case ("a"): {
                            boolean checkDepartment = false;
                            int index = 0;
                            int indexE = 0;
                            System.out.print("Enter Department ID: ");
                            String ID_entered = scanner.next();
                            for (Department department : departmentList) {
                                if (ID_entered.equals(department.getId())) {
                                    checkDepartment = true;
                                    index = departmentList.indexOf(department);
                                }
                            }
                            if (checkDepartment) {
                                System.out.println("HourlyEmployee: ");
                                for (Employee e : departmentList.get(index).getEmployeeList()) {
                                    if (e instanceof HourlyEmployee) {
                                        System.out.println(e.toString());
                                    }
                                }
                                System.out.println("SalesEmployee: ");
                                for (Employee e : departmentList.get(index).getEmployeeList()) {
                                    if (e instanceof SalesEmployee) {
                                        System.out.println(e.toString());
                                    }
                                }
                            } else {
                                System.out.println("Not exists this department");
                                break;
                            }
                            break;
                        }
                        case ("b"): {
                            System.out.print("Last Name: ");
                            String empLastName = scanner.next();
                            for (Department department : departmentList) {
                                for (Employee employee : department.getEmployeeList()) {
                                    if (employee.getLastname().equals(empLastName)) {
                                        System.out.print(department.getId() + "\n" + employee.toString() + "\n");
                                    }
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                case (6): {
                    for (Department department : departmentList) {
                        System.out.println(department.getId() + ": " + department.getEmployeeList().size() + " Employees");
                    }
                    break;
                }

            }

            System.out.print("Do you want to continue ? (y/n)");
            flag = scanner.next();
        }
        while (flag.equals("y"));
    }
}
