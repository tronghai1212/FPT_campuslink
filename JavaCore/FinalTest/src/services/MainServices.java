package services;

import entities.User;
import entities.UserRoles;
import entities.enums.Status;
import sun.applet.Main;

import java.io.*;
import java.util.*;

public class MainServices {
    /**
     * truyen vao user va ghi vao file
     * @param user
     * @throws IOException
     */
    public void fileWriter(User user) throws IOException {
        FileWriter fileWriter = new FileWriter("E:\\FinalTest\\document\\user.dat", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(user.toString());
        bufferedWriter.write("\n");
        bufferedWriter.close();
    }
    // doc file
    public void fileReader() throws IOException {
        FileReader fileReader = new FileReader("E:\\FinalTest\\document\\user.dat");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> userList = new ArrayList();
        while ((line = bufferedReader.readLine())!=null){
            userList.add(line);
        }
        bufferedReader.close();
        Collections.sort(userList);
        for (String line1:userList) {
            System.out.println(line1);
        }
    }

    /**
     * get detail user by userName
     * @param userName
     * @throws IOException
     */
    public void getUserDetail(String userName) throws IOException {
        FileReader fileReader = new FileReader("E:\\FinalTest\\document\\user.dat");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> userList = new ArrayList();
        while ((line = bufferedReader.readLine())!=null){
            userList.add(line);
        }
        bufferedReader.close();
        for (String userDetail:userList) {
            if (userDetail.contains("userName='" + userName + "'")){
                System.out.println(userDetail);
            }

        }
    }

    /**
     * User login
     * @param userName
     * @param password
     * @throws IOException
     */
    public void userLogin(String userName, String password) throws IOException {
        boolean check = false;
        FileReader fileReader = new FileReader("E:\\FinalTest\\document\\user.dat");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> userList = new ArrayList();
        while ((line = bufferedReader.readLine())!=null){
            userList.add(line);
        }
        bufferedReader.close();
        for (String userDetail:userList) {
            if (userDetail.contains("userName='" + userName + "'") && userDetail.contains("password='" + password + "'") ){
                check = true;
                break;
            }
            else {
                check = false;
            }
        }
        if (check == true){
            System.out.println("Login successfully");
        }
        else {
            System.out.println("invalid user name or password ");
        }
    }


    public void updateRole(String userName, UserRoles roles) throws IOException {
        File file = new File("E:\\FinalTest\\document\\user.dat");
        File fileCoppy = new File("E:\\FinalTest\\document\\user1.dat");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> userList = new ArrayList();
        while ((line = bufferedReader.readLine())!=null){
            userList.add(line);
        }
        bufferedReader.close();

        for (String userDetail:userList) {
            FileWriter fileWriter = new FileWriter(fileCoppy,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if ((userDetail.contains("userName='" + userName + "'") && userDetail.contains("status=ACTIVE"))==false){
                bufferedWriter.write(userDetail);
                bufferedWriter.write("\n");
            }
            else {
                String userUpdate = userDetail.replace("userRoles=id='1', authority='user', description='chi co quyen login'","userRoles=id='"+roles.getId()+"', authority='"+roles.getAuthority()+"', description='"+roles.getDescription()+"'");
                bufferedWriter.write(userUpdate);
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            file.delete();
            File newFile = new File("E:\\FinalTest\\document\\user.dat");
            fileCoppy.renameTo(newFile);
        }

    }

}
