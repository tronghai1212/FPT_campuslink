package ex2;

import java.util.Date;
import java.util.Scanner;

public class HourlyEmployee extends Employee {
    private double rate;
    private double workingHours;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String ssn, String firstName, String lastname, String address, Date birthDay, String phone, String email, double rate, double workingHours) {
        super(ssn, firstName, lastname, address, birthDay, phone, email);
        this.rate = rate;
        this.workingHours = workingHours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        super.addEmployee();
        System.out.print("Rate :");
        rate = scanner.nextDouble();
        System.out.print("Working Hours :");
        workingHours = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "rate=" + rate +
                ", workingHours=" + workingHours +
                ", ssn='" + getSsn() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", birthDay=" + getBirthDay() +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'';
    }
}
