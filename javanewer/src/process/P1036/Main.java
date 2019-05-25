package process.P1036;

import java.util.Scanner;

public class Main {
    private int n;
    private int k;
    private int[] array;
    private int result;

    private boolean isPrime(int val) {
        int s = (int) Math.sqrt(val) + 1;
        for (int i = 2; i < s; i++) {
            if (val % i == 0) return false;
        }
        return true;
    }

    private void recur(int count,int start,int total){
        if (count==k){
            if (isPrime(total)){
                result++;
            }
        }else{
            for (int i=start;i<=n-(k-count);i++){
                recur(count+1,i+1,total+array[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Main tool=new Main();
        tool.n=s.nextInt();
        tool.k=s.nextInt();
        tool.result=0;
        tool.array=new int[tool.n];
        for(int i=0;i<tool.n;i++){
            tool.array[i]=s.nextInt();
        }
        for (int i=0;i<=tool.n-tool.k;i++){
            tool.recur(1,i+1,tool.array[i]);
        }
        System.out.println(tool.result);
    }

}
