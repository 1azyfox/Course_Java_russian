public static int leapYearCount(int year) {
        int a = year / 100;
        int b = year % 100;
        int result = a / 4 + (b / 4) + (99/4 * a);
        return result;
        }