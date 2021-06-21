package process.P1028;

import java.util.Scanner;

public class Main {
    int[] record;

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        Main tool=new Main();
        tool.record=new int[n+1];
        for(int i=0;i<tool.record.length;i++){
            tool.record[i]=-1;
        }
        System.out.println(tool.count(n)+1);
    }

    private int count(int n){
        int count=0;
        for (int i=1;i<=n/2;i++){
            count++;
            count+=(record[i]==-1?count(i):record[i]);
        }
        record[n]=count;
        return count;
    }
}
