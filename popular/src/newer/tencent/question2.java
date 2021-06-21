package newer.tencent;

import java.util.Scanner;

public class question2 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=Integer.parseInt(s.nextLine());
        for (int i=0;i<t;i++){
            String str=s.nextLine();
            int count=0;
            boolean flag=false;
            int index=0;
            while(true){
                for (int j=index;j<str.length()-1;j++){
                    if (str.charAt(j)==str.charAt(j+1)){
                        str=str.substring(0,j)+str.substring(j+2);
                        count++;
                        flag=true;
                        index=j==0?0:j-1;
                        break;
                    }
                }
                if (!flag)break;
                else flag=false;
            }
            if (count%2==1){
                System.out.println("Yes,you can win!");
            }else {
                System.out.println("Oh,no.");
            }
        }
    }
}
