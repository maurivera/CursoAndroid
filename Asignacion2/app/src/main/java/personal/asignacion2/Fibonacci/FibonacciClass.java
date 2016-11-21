package personal.asignacion2.Fibonacci;

/**
 * Created by RIVARA on 11/20/2016.
 */

public class FibonacciClass {
    private long numbertoCalcutate = 0;

    public FibonacciClass(long number) {
        numbertoCalcutate = number;
    }

    public long calculateFibonacci() {
        return CalcularFibo(numbertoCalcutate);
    }

    public long CalcularFibo(long numberToCalc) {
        if (numberToCalc == 0)
            return 0;
        else if (numberToCalc == 1)
            return 1;
        else {
            return CalcularFibo(numberToCalc - 1) + CalcularFibo(numberToCalc - 2);
        }
    }
}
