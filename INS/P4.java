//PlayFair Algorithm :
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P4 {
    String  checkString = "";
    public static String printOnceLetter(String keyString){
        String result = "";
        
        Set<Character> seen = new HashSet<>();

        for (char c : keyString.toCharArray()) {
            if (!seen.contains(c)) {
                result += c;
                seen.add(c);
            }
        }
        for(char c  = 'a';c<='z';c++){
           
            if (c=='j') {
                continue;
            }
             else if(!seen.contains(c)){
                result +=c;
            }
        }
        // System.out.println(result);...
       return result;
    }
    
    public static String plainTextGenerate(char[] pt) {
        String pair = "";
        for(int i=0;i<pt.length-1;i++)
        {
            if(pt[i]!=pt[i+1])
            {
                pair=pair+pt[i]+pt[i+1];
                // System.out.println("Match not Charechter:"+pair);
                i++;
                if(i==pt.length-2)
                {
                    pair=pair+pt[i+1]+"x";
                    // System.out.println("append x:"+pair);
                    break;
                }        
            }
            else if(pt[i]==pt[i+1])
            {
                pair=pair+pt[i]+"x";
                // System.out.println("Matṇch Charechter:"+pair);
            }
        }
        return pair;
        
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Plain Text");
        String plaintText1 = sc.nextLine();
        String plaintText = plaintText1.replace('j', 'i');
        System.out.println("Enter Key :");
        String keyOrignal = sc.nextLine();
        char[][] matrix = new char[5][5];
        ArrayList<Character> str = new ArrayList<Character>();
        String key2 = keyOrignal.replace('j', 'i');
        String key = printOnceLetter(key2);
        char[] k = key.toCharArray();
        char[] pt = plaintText.toCharArray();
        String finalPlainText = plainTextGenerate(pt);
        char[] fpt = finalPlainText.toCharArray();
        System.out.println(finalPlainText); 
        String finalEncryptedString = "";  
        
        // Add  key elemts in Array List str which is used for print matrix
        for (char c : k) {
            str.add(c);
        }     
          
        // Print Final MAtrix
        for(int i =0;i<5;i++){
            for(int j =0;j<5;j++){
                    matrix[i][j] = str.get(i * 5 + j).toLowerCase(str.get(i * 5 + j));
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        } 
        for (int a = 0; a < fpt.length; a++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(fpt[a] == matrix[i][j] && fpt[a+1] ==matrix[i+1>4?(i+1)%5:(i+1)][j]){
                        // System.out.println(fpt[a] + "=>"+matrix[i][j]);
                        // System.out.println(a +"=>" + "["+i+"]["+j + "]");
                        // System.out.println(fpt[a+1] + "=>"+matrix[i+1>4?(i+1)%5:(i+1)][j]);
                        // System.out.println((a+1) +"=>" + "["+(i+1)+"]["+j + "]");
                        finalEncryptedString = finalEncryptedString + matrix[i+1>4?(i+1)%5:(i+1)][j] + matrix[i+2>4?(i+2)%5:(i+2)][j];
                        break;
                    }
                    else if(fpt[a] == matrix[i][j] && fpt[a+1] ==matrix[i][j+1>4?(j+1)%5:(j+1)]){
                        // System.out.println(fpt[a] + "=>"+matrix[i][j]);
                        // System.out.println(a +"=>" + "["+i+"]["+j + "]");
                        // System.out.println(fpt[a+1] + "=>"+matrix[i][j+1>4?(j+1)%5:(j+1)]);
                        // System.out.println((a+1) +"=>" + "["+(i)+"]["+(j+1) + "]");
                        finalEncryptedString = finalEncryptedString + matrix[i][j+1>4?(j+1)%5:(j+1)] + matrix[i][j+2>4?(j+2)%5:(j+2)];
                        break;
                    }
                    else{
                        if(fpt[a] == matrix[i][j]){
                            // System.out.println("==========================ESLE Block 1st IF===================");    
                            //     System.out.println(fpt[a] + "=>"+matrix[i][j]);
                            //     System.out.println(a +"=>" + "["+i+"]["+j + "]");
                                for (int m = 0; m < 5; m++) {
                                    for (int n = 0; n < 5; n++) {
                                        if(fpt[a+1]==matrix[m][n]){
                                            // System.out.println(fpt[a+1] + "=>" + matrix[m][n]);
                                            // System.out.println(a+1 +"=>" + "["+m+"]["+n + "]");
                                            // System.out.println(matrix[i][n] +"=>"+matrix[m][j]);
                                            finalEncryptedString = finalEncryptedString +  matrix[i][n] + matrix[m][j];
                                        }
                                    }
                                }
                                // System.out.println("==========================ESLE Block 1st IF===================");
                            break;
                        }
                    }
                 
                }
            }
            a++;
        }
        System.out.println("Encrypted String :"+finalEncryptedString);
        
    }
}
