package CMU.demo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        new Main().solution(new int[]{1, 3, 6, 4, 1, 2});
    }

    public int solution(int[] A) {
        int[] B=new int[A.length];
        int count=0;
        for (int a : A) {
            if (a > 0) {
                B[count]=a;
                count++;
            }
        }
        Arrays.sort(B,0,count);
        if(B[0]!=1){
            return 1;
        }
        for(int i=1;i<count;i++){
            if(B[i]-B[i-1]>1){
                return B[i-1]+1;
            }
        }
        return B[count-1]+1;
    }
}
