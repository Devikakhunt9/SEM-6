import java.util.Scanner;

public class ECB {
    public static void main(String[] args) {
        String cipherTexString = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Plain Text(Min Length : 8)");
        String plaintTexString = sc.nextLine();
        System.out.println("Enter Key :");
        String keyString = sc.nextLine();
        char[] ptArray = plaintTexString.toCharArray();
        for (int i = 0; i < ptArray.length; i = i+4) {
            String plaintSubString = plaintTexString.substring(i, i+4);
            int keyInt = Integer.parseInt(keyString);
            int plainInt = Integer.parseInt(plaintSubString);
            int ans = keyInt ^ plainInt;
            if(ans == 0){
                String binaryString = String.format("%04d", Integer.parseInt(Integer.toBinaryString(ans)));
            cipherTexString += binaryString;
            }
            else{
                cipherTexString +=(keyInt ^ plainInt);
                // System.out.println("Ans : " +(keyInt ^ plainInt));
                // // System.out.println(plaintSubString);
            }
            
        }       
        System.out.println("Cipher Text :" + cipherTexString);
        char[] cpiherArray = cipherTexString.toCharArray();
        String encString = "";
        for (int i = 0; i < cpiherArray.length; i = i+4) {
            String cipherSubString = cipherTexString.substring(i, i+4);
            int keyInt = Integer.parseInt(keyString);
            int cipherInt = Integer.parseInt(cipherSubString);
            int ans = ~(keyInt ^ cipherInt);
            if(ans == 0){
                String binaryString = String.format("%04d", Integer.parseInt(Integer.toBinaryString(ans)));
                encString += binaryString;
            }
            else{
                encString +=(keyInt ^ cipherInt);
                // System.out.println("Ans : " +(keyInt ^ plainInt));
                // // System.out.println(plaintSubString);
            }
            
        }
        System.out.println("Encrypt Text :" + encString);
    }
}
