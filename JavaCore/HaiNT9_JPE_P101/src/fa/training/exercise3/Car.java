package fa.training.exercise3;

import java.util.Scanner;

public class Car {
    private int speed;
    private double regularPrice;
    private String color;

    Scanner scanner = new Scanner(System.in);

    public Car() {
    }

    public Car(int speed, double regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public double getSalePrice() {
        return this.regularPrice;
    }

    public void input(Car car){
        System.out.println("nhap vao thong tin Car: ");
        System.out.print("Speed: ");
        car.setSpeed(scanner.nextInt());
        System.out.print("Regular Price: ");
        car.setRegularPrice(scanner.nextDouble());
        System.out.print("Color: ");
        car.setColor(scanner.next());
    }
}
