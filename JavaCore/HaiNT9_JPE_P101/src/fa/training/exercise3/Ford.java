package fa.training.exercise3;

import java.util.Scanner;

public class Ford extends Car {
    private int year;
    private int manufacturerDiscount;
    Scanner scanner = new Scanner(System.in);

    public Ford() {
    }

    public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getManufacturerDiscount() {
        return manufacturerDiscount;
    }

    public void setManufacturerDiscount(int manufacturerDiscount) {
        this.manufacturerDiscount = manufacturerDiscount;
    }

    @Override
    public double getSalePrice() {
        return super.getSalePrice() - this.manufacturerDiscount;
    }

    public void input(Ford ford) {
        System.out.println("nhap vao thong tin xe ford: ");
        System.out.print("Speed: ");
        ford.setSpeed(scanner.nextInt());
        System.out.print("Regular Price: ");
        ford.setRegularPrice(scanner.nextDouble());
        System.out.print("Color: ");
        ford.setColor(scanner.next());
        System.out.print("Year: ");
        ford.setYear(scanner.nextInt());
        System.out.print("Manufacturer Discount: ");
        ford.setManufacturerDiscount(scanner.nextInt());
    }
}
