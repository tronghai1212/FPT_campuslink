package entities;

import entities.enums.Status;
import services.MainServices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class User {
    Scanner scanner = new Scanner(System.in);
    private String id;
    private String userName;
    private String password;
    private UserRoles userRoles;
    private Status status;

    public boolean checkRegex(String userName, String password){
         String regex = "^(?=.{6,100}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        if (userName.matches(regex)==false || password.matches(regex) == false){
            System.out.println("vui long nhap lai username and password");
            return  false;
        }
        return  true;
    }

    public boolean checkUnique(String userName) throws IOException {
        List<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader("E:\\FinalTest\\document\\user.dat");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) !=null){
            list.add(line);
        }
        bufferedReader.close();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("userName='" + userName + "'")) {
                System.out.println("user da ton tai, vui long nhap lai!");
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }
    public User() {
    }

    public User(String id, String userName, String password, Status status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public User(String id, String userName, String password, UserRoles userRoles, Status status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userRoles = userRoles;
        this.status = status;
    }

    public User input() throws IOException {
        do {
            System.out.print("Nhap vao id n: ");
            id = scanner.nextLine();
            System.out.print("Nhap vao userName: ");
            userName = scanner.nextLine();
            System.out.print("Nhap vao password: ");
            password = scanner.nextLine();
        }while (checkRegex(userName,password) == false || checkUnique(userName) ==false);
        System.out.print("Nhap vao status: ");
        int check;
        check = scanner.nextInt();
        scanner.nextLine();
        if (check == 1 ){
            status = Status.ACTIVE;
        }
        else{
            status = Status.NOT_ACTIVE;
        }
        userRoles  = UserRoles.roleUser();
        return new User(id,userName,password,status);
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userRoles=" + userRoles.toString()+
                ", status=" + status +
                '}';
    }
}
