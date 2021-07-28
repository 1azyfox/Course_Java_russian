public class Main {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
//        String className = new Throwable().getStackTrace()[1].getClassName();
//        String methodName = new Throwable().getStackTrace()[1].getMethodName();
//        if (className.equals("Main") && methodName.equals("main")) {
//            return null;
//        }
//        return className + "#" + methodName;
        try {
            throw new Exception();

        } catch (Exception e) {
            StackTraceElement[] ses = e.getStackTrace();
            if (ses.length > 2) {
                return (ses[2].getClassName() + "#" + ses[2].getMethodName());
            } else {
                return null;
            }
        }
    }
}

