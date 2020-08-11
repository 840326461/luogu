package newer.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        ArrayList<String> resultList=new ArrayList<>();
        for (int i=0;i<n;i++){
            String str=s.next();
            int length=str.length();
            int j=0;
            while(true){
                if (length==j){
                    break;
                }
                if (length-j<8){
                    StringBuilder temp=new StringBuilder(str.substring(j));
                    for (int k=0;k<8-(length-j);k++){
                        temp.append('0');
                    }
                    resultList.add(temp.toString());
                    break;
                }else{
                    resultList.add(str.substring(j,j+8));
                    j+=8;
                }
            }
        }
        resultList.sort((o1, o2) -> {
            int length1 = o1.length();
            int length2 = o2.length();
            for (int i = 0; i < (length1 >= length2 ? length2 : length1); i++) {
                if (o1.charAt(i) > o2.charAt(i)) {
                    return 1;
                } else if (o1.charAt(i) < o2.charAt(i)) {
                    return -1;
                }
            }
            return Integer.compare(length1, length2);
        });

        for (String str:resultList) {
            System.out.print(str+" ");
        }
    }
}
