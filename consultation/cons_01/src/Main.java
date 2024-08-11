import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        int res = div(a, b);
        System.out.println(res);

        try {
            m1();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int div(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error. Divided by 0 is not correct.");
            return 0;
        } catch (Exception e) {
            System.out.println("There was an error");
            return 0;
        }
    }

    public static void m1 () throws Exception{
        throw new Exception();
    }


}

