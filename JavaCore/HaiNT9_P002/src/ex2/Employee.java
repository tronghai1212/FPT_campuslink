package ex2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee {
    private String ssn;
    private String firstName;
    private String lastname;
    private String address;
    private Date birthDay;
    private String phone;
    private String email;

    private static final String regex = "^(.+)@(.+)$";
    public int check;

    public Employee() {
    }

    public Employee(String ssn, String firstName, String lastname, String address, Date birthDay, String phone, String email) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastname = lastname;
        this.address = address;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
    }


    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int checkEmail(String email){
        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        if (email.matches(emailRegex)==false){
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
        if (phone.matches(numberPhoneRegex)==false){
            System.out.println("nhap sai dinh dang phone");
            check = 1;
            return 1;
        }
        else{
            check = 0;
            return 0;
        }
    }

    public String checkDate(String date) {
        check = 0;
        try {
            this.setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        } catch (ParseException e) {
            check = 1;
            return "Date to correct format (dd/mm/yyyy)";
        }
        return "Birthday: " + date;
    }

    public void addEmployee() {
        Scanner myObj = new Scanner(System.in);
        System.out.print("SSN: ");
        ssn = myObj.next();
        System.out.print("First name: ");
        firstName = myObj.next();
        System.out.print("Last name: ");
        lastname = myObj.next();
        System.out.print("Address: ");
        address = myObj.next();
        do {
            System.out.print("Birthday: ");
            String date = myObj.next();
            checkDate(date);
        }
        while (check == 1);
        do {
            System.out.print("Phone: ");
            phone = myObj.next();
            checkPhone(this.phone);
        }
        while (check == 1);
        do {
            System.out.print("Email: ");
            email = myObj.next();
            checkEmail(email);
        }
        while (check == 1);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", birthDay=" + birthDay +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
