//Caeser Cipher : ----
import java.util.Scanner;
public class P1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Choice :\n1.Encryption\n2.Decryption\n3.Exit");
        
        while (true) {
            System.out.print("\nEnter Your choice:");
            int a = sc.nextInt();
            if(a==1){
                System.out.println("Enter String:");
                sc.nextLine();
                String str = sc.nextLine();
                char[] ch = str.toCharArray();
                for (char c : ch) {
                    System.out.print((char)((int)c+3>122?(int)c-23:(int)c+3));
                }
            }

            if(a==2){
                System.out.println("Enter String:");
                sc.nextLine();
                String decString = sc.nextLine();
                char[] ch = decString.toCharArray();
                for (char c : ch) {
                    System.out.print((char)((int)c-3<97?(int)c+23:(int)c-3));
                }
            }
            if (a==3) {
                break;
            }
        }
    } 
}
