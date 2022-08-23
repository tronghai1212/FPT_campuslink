package fa.training.exercise3;

import java.util.Set;

public class MyOwnAutoShop {
    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        Ford ford1 = new Ford();
        Ford ford2 = new Ford();
        Car car = new Car();
        sedan.input(sedan);
        ford1.input(ford1);
        ford2.input(ford2);
        car.input(car);

        System.out.println("Sale price: ");
        System.out.printf("Sedan: %.2f\n", sedan.getSalePrice());
        System.out.printf("Ford1: %.2f\n", ford1.getSalePrice());
        System.out.printf("Ford2: %.2f\n", ford2.getSalePrice());
        System.out.printf("Car: %.2f\n", car.getSalePrice());
    }
}
