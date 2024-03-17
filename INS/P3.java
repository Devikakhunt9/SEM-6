//PolyAlphabatic ALgo::::
import java.util.Scanner;
public class P3 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Encrypted Text :");
        String plainTexString = sc.nextLine();
        char[] pt = plainTexString.toCharArray();
        System.out.println("Enter Key :");
        String keyTeString = sc.nextLine();
        String cipherString = "";
        String cipherString2 = "";
        String finalAnsEncString = "";
        String finalAnsEncString2 = "";
        char[] k = keyTeString.toCharArray();
        char[] k2 = keyTeString.toCharArray();
        String keyTeString2 = keyTeString;
        int count = 0,count2 =0;
        int originalKeyLength = keyTeString.length();

        while (keyTeString.length() != plainTexString.length()) {
            // System.out.println(i);
            // System.out.println("key and plaintext :"+keyTeString.length()+"=="+plainTexString.length());
                if(keyTeString.length() < plainTexString.length()){
                    // System.out.println("key and count :"+count+"=="+originalKeyLength);

                    if (count == originalKeyLength) {
                        // System.out.println("orginal if executed");
                        count = 0;
                    }
                    else{
                        keyTeString += k[count];
                        count++;
                    }
                }
                
        }
        while (keyTeString2.length() != plainTexString.length()) {
            // System.out.println(i);
            // System.out.println("key and plaintext :"+keyTeString.length()+"=="+plainTexString.length());
                if(keyTeString2.length() < plainTexString.length()){
                    // System.out.println("key and count :"+count+"=="+originalKeyLength);
                    keyTeString2 += pt[count2];
                        count2++;
                }
        }
        System.out.println(keyTeString + "(vigener) => " + keyTeString2+"(verner)");
        k= keyTeString.toCharArray();
        
        //Encryption :-------
        for (int i =0;i<pt.length;i++) {
            cipherString += ((((int)pt[i] + (int)k[i])-97)>122?(char)(((((int)pt[i] + (int)k[i])-97)%122)+96):(char)(((int)pt[i] + (int)k[i])-97));
            // System.out.print((((int)pt[i] + (int)k[i])-97)>122?(char)(((((int)pt[i] + (int)k[i])-97)%122)+96):(char)(((int)pt[i] + (int)k[i])-97));
            
        }
        System.out.println("Encrpt String (vigener) :: "+cipherString);
        char[] ct = cipherString.toCharArray(); 
        //Decryption :-------
        for (int i =0;i<ct.length;i++) {
            finalAnsEncString += ((int)(ct[i] - k[i])<0?(char)((int)((26 + ((ct[i] - k[i])))+97)):(char)((int)((ct[i] - k[i])+97)));
            // System.out.println((int)(ct[i] - k[i])<0?(char)((int)((26 + ((ct[i] - k[i])))+97)):(char)((int)((ct[i] - k[i])+97)));
        }
        System.out.println("Decrept String (vigener) :: " + finalAnsEncString);


        k2= keyTeString2.toCharArray();
        
        //Encryption :-------
        for (int i =0;i<pt.length;i++) {
            cipherString2 += ((((int)pt[i] + (int)k2[i])-97)>122?(char)(((((int)pt[i] + (int)k2[i])-97)%122)+96):(char)(((int)pt[i] + (int)k2[i])-97));
            // System.out.print((((int)pt[i] + (int)k[i])-97)>122?(char)(((((int)pt[i] + (int)k[i])-97)%122)+96):(char)(((int)pt[i] + (int)k[i])-97));
            
        }
        System.out.println("Encrpt String (verner) :: "+cipherString2);
        char[] ct2 = cipherString2.toCharArray(); 
        //Decryption :-------
        for (int i =0;i<ct2.length;i++) {
            finalAnsEncString2 += ((int)(ct2[i] - k2[i])<0?(char)((int)((26 + ((ct2[i] - k2[i])))+97)):(char)((int)((ct2[i] - k2[i])+97)));
            // System.out.println((int)(ct[i] - k[i])<0?(char)((int)((26 + ((ct[i] - k[i])))+97)):(char)((int)((ct[i] - k[i])+97)));
        }
        System.out.println("Decrept String (verner) :: " + finalAnsEncString2);


        
    }
}
