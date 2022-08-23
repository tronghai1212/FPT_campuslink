package exercise2;

import java.util.Scanner;

public class ArrayContains {
    Scanner scanner = new Scanner(System.in);
    public void ex1(){
        boolean check=false;
        String[] stringArray = {"FTP", "Fresher", "Acedemy", "2018"};
        String sValue;
        sValue = scanner.nextLine();
        for (int i = 0; i<stringArray.length; i++){
            if (stringArray[i].contains(sValue)){
                check= true;
            }
        }
        if (check==true){
            System.out.println("Check "+sValue+" in Array: Contained!");
        }
        else {
            System.out.println("Check "+sValue+" in Array: No Contain");
        }
    }


}
