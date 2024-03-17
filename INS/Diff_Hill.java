import java.util.Scanner;

public class Diff_Hill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter q :");
        int q = sc.nextInt();
        System.out.println("Enter Alpha :");
        double alpha = sc.nextInt();
        System.out.println("Enter XA :");
        double xa = sc.nextInt();
        System.out.println("Enter XB :");
        double xb = sc.nextInt();
        double ya = (Math.pow(alpha,xa))%q;
        double yb = (Math.pow(alpha,xb))%q;
        double akey = (Math.pow(yb, xa))%q;
        double bkey = (Math.pow(ya, xb))%q;
        System.out.println("Key By User A :"+akey + "\nKey By User B :"+bkey);
    }
}
