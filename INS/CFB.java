import java.util.Scanner;

public class CFB {
    public static void main(String[] args) {
        String encTextString = "";
        String decTextString = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Plain Text(8 bits) :");
        String plainTextString = sc.nextLine();
        System.out.println("Enter Key (8 bits) :");
        String keyTextString = sc.nextLine();
        String initialvector = "12345678";

        char[] pt = plainTextString.toCharArray();
        //length of sbits : 4  & length of b-s bits : 4
        for (int i = 0; i < pt.length; i=i+4) {
            
            //Apply Encryption (Simple XOR)::
            int encryptedAns = Integer.parseInt(keyTextString) ^ Integer.parseInt(initialvector);
            // System.out.println("Encrypted Ans :: "+encryptedAns);
            String encryptedAnsString = Integer.toString(encryptedAns);

            // Apply Plain & Encrypted XOR ::

            String encryptedSubString = encryptedAnsString.substring(i,i+4);
            String plainSubString = plainTextString.substring(i, i+4);
            int xorOfPlainAndEncryptrd = Integer.parseInt(encryptedSubString) ^ Integer.parseInt(plainSubString);
            // System.out.println("XOR of plain and encrypted message of 1st 4 digit :: "+xorOfPlainAndEncryptrd);
            // System.out.println(initialvector+"=>"+initialvector.substring(i+4));
            encTextString += xorOfPlainAndEncryptrd;
            // initialvector =initialvector.substring(i+4)+ Integer.toString(xorOfPlainAndEncryptrd);
            initialvector = encryptedAnsString.substring(i+4,8) + xorOfPlainAndEncryptrd;
            // System.out.println(initialvector);
            // System.out.println("initial vector :: " + initialvector);
        }
        System.out.println("Encrypted Text :"+encTextString);

        //Decryption ::::
        initialvector = "12345678"; 
        char[] cipherTextArray = encTextString.toCharArray();
        //length of sbits : 4  & length of b-s bits : 4
        for (int i = 0; i < cipherTextArray.length; i=i+4) {
            
            //Apply Encryption (Simple XOR)::
            int encryptedAns = Integer.parseInt(keyTextString) ^ Integer.parseInt(initialvector);
            // System.out.println("Encrypted Ans :: "+encryptedAns);
            String encryptedAnsString = Integer.toString(encryptedAns);

            // Apply Cipher & Encrypted XOR ::

            String encryptedSubString = encryptedAnsString.substring(i,i+4);
            String cipherSubString = encTextString.substring(i, i+4);
            int xorOfCipherAndEncryptrd = Integer.parseInt(encryptedSubString) ^ Integer.parseInt(cipherSubString);
            // System.out.println("XOR of plain and encrypted message of 1st 4 digit :: "+xorOfCipherAndEncryptrd);
            // System.out.println(initialvector+"=>"+initialvector.substring(i+4));
            decTextString += xorOfCipherAndEncryptrd;
            initialvector =encryptedAnsString.substring(i+4,8)+ (cipherSubString);
            // System.out.println("initial vector :: " + initialvector);
        }
        System.out.println("Decrypted Text :"+decTextString);
    }
}
