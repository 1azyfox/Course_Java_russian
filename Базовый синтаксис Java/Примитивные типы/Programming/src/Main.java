public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a && b) && (!d && !c) || (a && c) && (!b && !d) || (a && d) && (!b && !c) || (b && c) && (!a && !d) || (b && d) && (!a && !c) || (c && d) && (!a && !b);
        }