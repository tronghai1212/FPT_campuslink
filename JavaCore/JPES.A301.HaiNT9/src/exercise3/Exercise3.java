package exercise3;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("nhap 1 so trong [1,20]: ");
        int a = scanner.nextInt();

        while ((a < 1) || (a > 20)) {
            System.out.print("nhap lai  [1,20]: ");
            a = scanner.nextInt();
        }

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
