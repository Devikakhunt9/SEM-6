import java.util.Scanner;

public class RailFenceCipher {

    public static void encrypt(String plaintext, int rails, StringBuilder ciphertext) {
        int len = plaintext.length();
        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = i; j < len; j += rails * 2 - 2) {
                ciphertext.append(plaintext.charAt(j));
                if (i != 0 && i != rails - 1 && j + (rails - i - 1) * 2 < len) {
                    ciphertext.append(plaintext.charAt(j + (rails - i - 1) * 2));
                }
            }
        }
    }

    public static void decrypt(String ciphertext, int rails, StringBuilder decryptedtext) {
        int len = ciphertext.length();
        int cols = (int) Math.ceil((double) len / (2 * rails - 2)); // Calculate number of columns
        char[][] matrix = new char[rails][cols];
        int index = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rails; j++) {
                if (index < len) {
                    matrix[j][i] = ciphertext.charAt(index++);
                } else {
                    matrix[j][i] = ' '; // Pad with space if ciphertext is shorter
                }
            }
        }
        index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rails - 1 || (i + j) % (rails - 1) == 0) {
                    decryptedtext.append(matrix[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String input, output;
        int rails;
        do {
            System.out.println("\nRail Fence Cipher Menu:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter plaintext: ");
                    scanner.nextLine(); // Consume newline
                    input = scanner.nextLine();
                    System.out.print("Enter number of rails: ");
                    rails = scanner.nextInt();
                    StringBuilder encryptedText = new StringBuilder();
                    encrypt(input, rails, encryptedText);
                    System.out.println("Encrypted text: " + encryptedText);
                    break;
                case 2:
                    System.out.print("Enter ciphertext: ");
                    scanner.nextLine(); // Consume newline
                    input = scanner.nextLine();
                    System.out.print("Enter number of rails: ");
                    rails = scanner.nextInt();
                    StringBuilder decryptedText = new StringBuilder();
                    decrypt(input, rails, decryptedText);
                    System.out.println("Decrypted text: " + decryptedText);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);
        scanner.close();
    }
}
