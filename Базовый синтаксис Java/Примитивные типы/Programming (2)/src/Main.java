public static boolean doubleExpression(double a, double b, double c) {
        if (Math.abs((a + b) - c) <0.0001) {
        return true;
        }
        return false;
        }