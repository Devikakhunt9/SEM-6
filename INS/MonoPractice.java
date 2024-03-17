import java.util.Random;
import java.util.Scanner;

public class MonoPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String encString = "";
        String decString = "";
        String defaluString = "abcdefghijklmnopqrstuvwxyz";
        char[] defalut = defaluString.toCharArray();
        char[] key = defaluString.toCharArray();
        shuffleArray(key);
        for (char ch : defaluString.toCharArray()) {
            System.out.print(ch+"|");
        }
        System.out.println();
        for (char ch : key) {
            System.out.print(ch+"|");
        }
        System.out.println();
        System.out.println("Enter String :");
        String plainTexString = sc.nextLine();
        char[] pt = plainTexString.toCharArray();
        for (int i = 0; i < pt.length; i++) {
            for (int j = 0; j < defalut.length; j++) {
                if (pt[i] ==defalut[j] ) {
                    // System.out.print(key[j]);
                    encString +=key[j];
                } 
            }
        }
        System.out.println(encString);
        char[] ct = encString.toCharArray();

        for (int i = 0; i < ct.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (ct[i] == key[j]) {
                    // System.out.println(defalut[j]);
                    decString += defalut[j];
                }
            }
        }
        System.out.println(decString);

    }
    public static void shuffleArray(char[] arr) { 
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = rand.nextInt(arr.length);
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
