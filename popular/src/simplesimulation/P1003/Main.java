package simplesimulation.P1003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[][] list=new int[n][5];
        for (int i=0;i<n;i++){
            list[i][0]=i;
            for(int j=1;j<5;j++){
                list[i][j]=s.nextInt();
            }
        }
        int a=s.nextInt();
        int b=s.nextInt();
        for(int i=n-1;i>=0;i--){
            if(a>=list[i][1]&&a<=list[i][3]+list[i][1]&&b>=list[i][2]&&b<=list[i][2]+list[i][4]){
                System.out.print(i+1);
                return;
            }
        }
        System.out.print(-1);
    }

}
