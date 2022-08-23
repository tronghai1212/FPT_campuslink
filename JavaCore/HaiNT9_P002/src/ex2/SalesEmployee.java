package ex2;

import java.util.Date;
import java.util.Scanner;

public class SalesEmployee extends Employee {
    private int units;


    public SalesEmployee() {
    }

    public SalesEmployee(String ssn, String firstName, String lastname, String address, Date birthDay, String phone, String email, int units) {
        super(ssn, firstName, lastname, address, birthDay, phone, email);
        this.units = units;

    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        super.addEmployee();
        System.out.print("Units :");
        units = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "SalesEmployee{" +
                "units=" + units +
                ", ssn='" + getSsn() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", birthDay=" + getBirthDay() +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'';
    }

    public double getMonthlySalary() {
        if (this.units <= 25) {
            return this.units * 100;
        } else {
            return 25 * 100 + (this.units - 25) * 150;
        }
    }

}
