package personal.asignacion2.Factorial;

/**
 * Created by RIVARA on 11/20/2016.
 */
public class FactorialClass {

    private long numbertoCalcutate = 1;

    public FactorialClass(long number) {
        numbertoCalcutate = number;
    }

    public long calculateFactorial() {
        long returnFactorialNumber = 1;

        for (long i = 1; i <= numbertoCalcutate; i++) {
            returnFactorialNumber = returnFactorialNumber * i;
        }

        return returnFactorialNumber;
    }
}
