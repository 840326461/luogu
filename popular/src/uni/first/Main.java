package uni.first;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static char[] chars;
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String in=s.nextLine();
        chars=new char[in.length()];
        for(int i=0;i<in.length();i++){
            chars[i]=in.charAt(i);
        }
        Arrays.sort(chars);
        recur("",0);
    }

    static void recur(String last,int next){
        if(next==chars.length){
            System.out.print(last+" ");
            return;
        }
        for(int j=1;j<=3;j++){
            recur(last+chars[next]+j,next+1);
        }
    }
}
