package ex1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateProgram {
    private String phoneNumber;
    private String email;
    private static final String regex = "^(.+)@(.+)$";
    private Date date;
    int check=0;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int checkEmail(String email){
        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        if (phoneNumber.matches(emailRegex)==false){
            System.out.println("nhap sai dinh dang email");
            check = 1;
            return 1;
        }
        else{
            check = 0;
            return 0;
        }
    }

    public int checkPhone(String phone){
        String numberPhoneRegex = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
        if (phoneNumber.matches(numberPhoneRegex)==false){
            System.out.println("nhap sai dinh dang phone");
            check = 1;
            return 1;
        }
        else{
            check = 0;
            return 0;
        }
    }


    public static void main(String[] args) {
        ValidateProgram validateProgram = new ValidateProgram();
        Scanner scanner = new Scanner(System.in);
        String flag = null;
        do {
            System.out.println("====== Validate Program ======");
            System.out.print("Choose what you want to validate Phone Number/Email/Date: (p/e/d) ");
            String type = scanner.next();
            switch (type) {
                case "p": {
                    do {
                        System.out.print("Phone Number: ");
                        validateProgram.phoneNumber = scanner.next();
                        validateProgram.checkPhone(validateProgram.phoneNumber);
                    }
                    while (validateProgram.check==1);
                    break;
                }
                case "e": {
                    do {
                        System.out.print("Email: ");
                        validateProgram.email = scanner.next();
                        validateProgram.checkEmail(validateProgram.email);
                    }
                    while (validateProgram.check==1);
                    break;
                }
                case "d": {
                    System.out.print("Date: ");
                    String date = scanner.next();
                    try {
                        validateProgram.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(date));
                    } catch (ParseException e) {
                        System.out.println("nhap dung format (dd/mm/yyyy)");
                    }
                    break;
                }
                default: {
                    System.out.println("Please enter p/e/d ");
                }
            }
            System.out.print("Do you want to continue? (y/n) ");
            flag = scanner.next();
        }
        while (flag.equals("y"));
    }
}
