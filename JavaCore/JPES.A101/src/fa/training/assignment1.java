package fa.training;

import java.util.Scanner;

public class assignment1 {
    Scanner scanner = new Scanner(System.in);
    public void ArithmeticExercise1(){
        System.out.println(-5 + 8 * 6);
        System.out.println((55+9) % 9);
        System.out.println(20 + -3*5 / 8);
        System.out.println(5 + 15 / 3 * 2 - 8 % 3);
    }

    public void ArithmeticExercise2(){
        int first;
        int second;
        first = scanner.nextInt();
        second = scanner.nextInt();
        System.out.println(first+"+"+second+" = "+ (first+second));
        System.out.println(first+"-"+second+" = "+ (first-second));
        System.out.println(first+"x"+second+" = "+ (first*second));
        System.out.println(first+"/"+second+" = "+ (first/second));
        System.out.println(first+"%"+second+" = "+ (first%second));
    }

    public void JavaExercise(){
        System.out.println("   J    a   v     v  a\n" +
                "   J   a a   v   v  a a\n" +
                "J  J  aaaaa   V V  aaaaa\n" +
                " JJ  a     a   V  a     a");

    }

    public void ArithmeticExercise3(){
        System.out.println(((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)));
    }

    public void CircleExercise(){
        double radius;
        radius = scanner.nextDouble();
        System.out.println("Perimeter is = "+radius*2*3.14);
        System.out.println("Area is = "+radius*radius*3.14);
    }
    public void RectangleExercise(){
        double width, length;
        width = scanner.nextDouble();
        length = scanner.nextDouble();
        System.out.println("Perimeter is = "+(width+length)*2);
        System.out.println("Area is = "+(width*length));
    }

    public void LogicalExercise(int a, int b){
        if (a!= b){
            System.out.println(a + "!="+ b);
            if (a<=b){
                System.out.println(a + "<"+b);
                System.out.println(a + "<="+b);
            }
            if (a>=b){
                System.out.println(b + "<="+a);
            }
        }
        else {
            System.out.println(a +"="+b);
        }
    }
}
