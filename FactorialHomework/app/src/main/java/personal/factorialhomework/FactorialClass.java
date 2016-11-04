package personal.factorialhomework;

/**
 * Created by RIVARA on 10/30/2016.
 */

public class FactorialClass {

    private int numbertoCalcutate = 1;

    public FactorialClass(int number){
        numbertoCalcutate = number;
    }

    public int calculateFactorial(){
        int returnFactorialNumber= 1;

        for (int i=1; i<=numbertoCalcutate; i++){
            returnFactorialNumber = returnFactorialNumber * i;
        }

        return returnFactorialNumber;
    }
}
