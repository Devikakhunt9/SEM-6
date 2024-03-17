import java.util.*;

public class Railfence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter Plain Text: ");
        String pt = sc.nextLine(); 
        System.out.print("Enter Key for encrypt: ");
        int k = sc.nextInt();
        String ct="";

        char [] plaintext = pt.toCharArray();       
        int c=0;
        for(int i=k;i>0;i--)
        {
            int diff=0;
            int a=0;
            if(i==1)
            {
                diff=((k-1)*2);
            }
            else
            {
                diff=((i-1)*2);
            }
            a=c;
            for(int j=0;j<pt.length();j++)
            {
                
                if(a>=pt.length())
                {
                    break;
                }
               
                else 
                {
                    ct=ct+plaintext[a];
                   
                    if(i==k || i==1)
                    {
                        a=a+diff;
                    }
                    else
                    {
                        
                        if( a+diff<pt.length())
                        {
                            a=a+diff;
                            if( a+(c*2)/(k)<pt.length()){
                                ct=ct+plaintext[a];
                                a=a+(c*2);
                            }
                            else
                            {
                                break;
                            }
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
            c++;
        }
        System.out.println(ct);
        System.out.println(ct.length());
    }
}