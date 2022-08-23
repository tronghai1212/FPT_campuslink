package exercise4;

import java.util.Scanner;

public class ArrayReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] myIntArray = new int[len];
        System.out.println("nhap vao mang: ");
        int k = 0;
        do {
            myIntArray[k] = scanner.nextInt();
            k++;
        }
        while (k < len);

        System.out.print("Original Array: ");
        for (int i = 0; i < myIntArray.length; i++) {
            if (i == myIntArray.length - 1) {
                System.out.print(myIntArray[i]);
            } else {
                System.out.print(myIntArray[i] + ", ");
            }
        }

        System.out.print("\n Reversed Array: ");
        for (int j = myIntArray.length - 1; j >= 0; j--) {
            if (j == 0) {
                System.out.print(myIntArray[j] + "s");
                ;
            } else {
                System.out.print(myIntArray[j] + ", ");
            }
        }
    }
}
