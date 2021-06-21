package newer.huawei;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        StringBuilder result=new StringBuilder();
        String input=s.next();
        int length=input.length();
        int rightBrace;
        int times;
//        for (int i=0;i<length;i++){
//            char c=input.charAt(i);
//            if (isDigit(c)){
//                times=c-0x30;
//                i++;
//                leftBrace=i;
//                i++;
//                while(true){
//                    if (input.charAt(i)!=')'){
//                        i++;
//                    }else {
//                        break;
//                    }
//                }
//                String piece=input.substring(leftBrace+1,i);
//                for (int j=0;j<times;j++){
//                    result.append(piece);
//                }
//            }else {
//                result.append(c);
//            }
//        }
        for (int i=length-1;i>=0;i--){
            char c=input.charAt(i);
            if (c==')'){
                rightBrace=i;
                i--;
                while(true){
                    if (input.charAt(i)!='('){
                        i--;
                    }else {
                        break;
                    }
                }
                i--;
                times=input.charAt(i)-0x30;
                String piece=input.substring(i+2,rightBrace);
                for (int j=0;j<times;j++){
                    result.append(piece);
                }
            }else {
                result.append(c);
            }
        }
        System.out.println(result.toString());
    }

    private static boolean isDigit(char c){
        return c>=0x30&&c<0x39;
    }
}
