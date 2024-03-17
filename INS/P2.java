//Mono Alphabatic : ---
import java.util.Random;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        String defalutString = "abcdefghijklmnopqrstuvwxyz";
        String decString = "";
        String encString = "";
        char[] key = defalutString.toCharArray();
        char[] value = defalutString.toCharArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String:");
        String encrypted = sc.nextLine();
        char[] ans = new char[encrypted.length()];
        char[] ch = encrypted.toCharArray();
        shuffleArray(key);
        System.out.print("Original String    :");
        for (char v : value) {
            System.out.print(v+"|");
        }
        System.out.println();
        System.out.print("Key OF the Alphabet:");
        for (char k : key) {
            System.out.print(k+"|");
        }
        System.out.println();
        for (int i = 0;i<ch.length;i++) {
            for(int j = 0;j<value.length;j++){
                if (ch[i] == value[j]) {
                    decString += key[j]; 
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("Encrypted Ans :: "+decString);
        char[] dec = decString.toCharArray();
        for (int i = 0;i<ans.length;i++) {
            for(int j = 0;j<key.length;j++){
                if (dec[i] == key[j]) {
                    encString += value[j];
                    break;
                }
            }
        }   
        System.out.print("Decrypted Ans :: "+encString);
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
