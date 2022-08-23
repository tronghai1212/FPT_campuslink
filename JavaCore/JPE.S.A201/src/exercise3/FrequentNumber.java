package exercise3;

import java.util.Scanner;

public class FrequentNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flag;

        int len = scanner.nextInt();
        int value = scanner.nextInt();
        int valuecount = 0;


        int[] intArray = new int[len];

        int i = 0;
        do {
            System.out.print("nhap vao mang: ");
            intArray[i] = scanner.nextInt();
            i++;
            if (i >= len) {
                break;
            }
            System.out.println("Do you want to continue? y/n");
            flag = scanner.next();
        }
        while (flag.equals("y"));

        for (int j = 0; j < len; j++) {
            if (value == intArray[j]) {
                valuecount++;
            }
        }

        System.out.println("Amount of frequence: " + valuecount);
        System.out.print("Indexs: ");
        for (int k = 0; k < len; k++) {
            if (value == intArray[k]) {
                System.out.print(k + " ");
            }
        }
    }
}
