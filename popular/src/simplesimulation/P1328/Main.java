package simplesimulation.P1328;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a=s.nextInt();
        int b=s.nextInt();
        int[] listA=new int[a];
        int[] listB=new int[b];
        int scoreA=0,scoreB=0;
        int score[][]=new int[][]{
                {0,0,1,1,0},
                {1,0,0,1,0},
                {0,1,0,0,1},
                {0,0,1,0,1},
                {1,1,0,0,0}
        };
        for(int i=0;i<a;i++){
            listA[i]=s.nextInt();
        }
        for(int i=0;i<b;i++){
            listB[i]=s.nextInt();
        }
        for(int i=1;i<=n;i++){
            int stepA=listA[(i-1)%a];
            int stepB=listB[(i-1)%b];
            scoreA+=score[stepA][stepB];
            scoreB+=score[stepB][stepA];
        }
        System.out.print(scoreA+" "+scoreB);
    }
}
