package check;

public class Check {
    public static void range(Boolean exp, int errInfo) {
        if(!exp)
            System.out.println("Type failure: " + errInfo + " out of range");
    }
    public static void range(Boolean exp, String errInfo) {
        if(!exp)
            System.out.println("Type failure: " + errInfo + " out of range");
    }
    public static void valid(Boolean exp, String errInfo) {
        if(!exp)
            System.out.println("Type failure: " + errInfo);
    }
}
