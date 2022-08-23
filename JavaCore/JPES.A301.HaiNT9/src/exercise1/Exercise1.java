package exercise1;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int smaller;
        int larger;

        System.out.print("nhap 1 so tu [1,1000]: ");
        int a = scanner.nextInt();

        System.out.print("nhap 1 so tu [1,1000]: ");
        int b = scanner.nextInt();

        if (a == b) {
                System.out.print("Hai số không được bằng nhau. Vui lòng nhập lại số thứ hai: ");
                b = scanner.nextInt();
        }
        if (a < b) {
            smaller = a;
            larger = b;
        } else {
            smaller = b;
            larger = a;
        }
        while (smaller < 0) {
            System.out.print("Nhap lai so nho: ");
            smaller = scanner.nextInt();
        }

        while (larger > 1000) {
            System.out.print("Nhap lai so lon: ");
            larger = scanner.nextInt();
        }

        System.out.printf("so le giua %d va %d :\n", smaller, larger);
        for (int i = smaller; i <= larger; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
