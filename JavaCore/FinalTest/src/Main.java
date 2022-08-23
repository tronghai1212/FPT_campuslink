import entities.User;
import entities.UserRoles;
import services.MainServices;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        MainServices mainServices = new MainServices();
        User user = new User();
        String flag = null;
        do {
            System.out.println("====== USER MANAGEMENT SYSTEM ======\n"
                    + "1.Create a new user\n"
                    + "2.Display list of all user information\n"
                    + "3.Update role\n"
                    + "4.View an User\n"
                    + "5.Login system\n"
                    + "6.Exit");
            flag = scanner.nextLine();
            switch (flag) {
                case "1": {
                    user.input();
                    mainServices.fileWriter(user);
                    break;
                }
                case "2": {
                    mainServices.fileReader();
                    break;
                }
                case "3": {
                    System.out.print("Nhap vao username can update: ");
                    String userName = scanner.nextLine();
                    mainServices.updateRole(userName, UserRoles.roleAdmin());
                    break;
                }
                case "4": {
                    System.out.print("Nhap vao username can tim: ");
                    String userNameFind = scanner.nextLine();
                    mainServices.getUserDetail(userNameFind);
                    break;
                }
                case "5": {
                    System.out.print("Nhap vao username ");
                    String userName = scanner.nextLine();
                    System.out.print("Nhap vao password ");
                    String password = scanner.nextLine();
                    mainServices.userLogin(userName, password);
                    break;
                }
                case "6": {
                    break;
                }
            }
        }
        while (!flag.equals("6"));
    }
}
