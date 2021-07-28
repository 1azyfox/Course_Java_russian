import java.util.function.DoubleUnaryOperator;

public class Main {
    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate(x -> Math.sin(x) / x, 1, 5));//0.603848
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double gridStep = 0.0000001;
        double result = 0;
        boolean cycleContinue = true;
        for (double j = a; cycleContinue && b - j != 0; j = Double.sum(j, gridStep)) {
            if (b - j > gridStep) {
                cycleContinue = true;
            } else {
                if (j - b > gridStep*2) {
                    cycleContinue = false;
                } else {
                    cycleContinue = false;
                }
            }
            result += (f.applyAsDouble(j)) * (gridStep);
        }
        return (double) Math.round((result*1000000))/1000000;
    }
}

