package fa.training.ex1;

public class Ex1 {
    // a + bi
    double a;
    double b;

    public Ex1(){
        this.a =0;
        this.b = 0;
    }
    public Ex1(double a){
        this.a = a;
        this.b = 0;
    }
    public Ex1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public static Ex1 plus(Ex1 number1, Ex1 number2){
        Ex1 plusNumber = new Ex1();
        plusNumber.a = number1.a + number2.a;
        plusNumber.b = number1.b + number2.b;
        return plusNumber;
    }

    public static Ex1 product(Ex1 number1, Ex1 number2){
        Ex1 productNumber = new Ex1();
        productNumber.a = (number1.a*number2.a)-(number1.b* number2.b);
        productNumber.b = (number1.a*number2.b)+(number2.a* number1.b);
        return productNumber;
    }

    public static String printf(Ex1 ex1){
        return ex1.a+" + " + ex1.b + "i";
    }

    public static void main(String[] args) {
        Ex1 ex1 = new Ex1(3,2);
        Ex1 ex2 = new Ex1(4,-2);
        System.out.println(printf(plus(ex1,ex2)));
        System.out.println(printf(product(ex1,ex2)));

    }
}
