package fa.training.exercise3;

import java.util.Scanner;

public class Sedan extends Car{
    Scanner scanner = new Scanner(System.in);
    private int length;

    public int getLength() {
        return length;
    }

    public Sedan() {
    }

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public double getSalePrice() {
        return super.getSalePrice() * (this.length > 20 ? 0.95 : 0.90);
    }

    public void input(Sedan sedan){
        System.out.println("nhap vao thong tin Sedan: ");
        System.out.print("Speed: ");
        sedan.setSpeed(scanner.nextInt());
        System.out.print("Regular Price: ");
        sedan.setRegularPrice(scanner.nextDouble());
        System.out.print("Color: ");
        sedan.setColor(scanner.next());
        System.out.print("Length: ");
        sedan.setLength(scanner.nextInt());
    }
}
