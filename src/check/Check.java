package check;

public class Check {
    public static void valid(Boolean exp, String errInfo) {
        if(!exp)
            System.out.println("Type failure: " + errInfo);
    }
    public static void range(Boolean exp, String errInfo) {
        valid(exp, errInfo + " out of range");
    }
    public static void range(Boolean exp, int errInfo) {
        range(exp, String.valueOf(errInfo));
    }
}
