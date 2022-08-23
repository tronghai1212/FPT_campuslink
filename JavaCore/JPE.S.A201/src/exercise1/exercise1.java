package exercise1;

public class exercise1 {
    public void SumAverageRunningInt(int lowerbound, int upperbound){
        lowerbound = 1;
        upperbound = 100;
        int total = 0;
        for (int i =lowerbound; i<=upperbound; i++){
            total=total+i;
        }
        System.out.println("Average of all "+ upperbound+ " first numbers:"+ total/(upperbound-lowerbound+1));
    }

}
