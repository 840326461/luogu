package array.P2141;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] array=new int[n];
        for (int i=0;i<n;i++){
            array[i]=s.nextInt();
        }
        Arrays.sort(array);
        int count=0;
        for (int i=2;i<n;i++){
            int a=0;
            int b=i-1;
            while(a!=b){
                if (array[a]+array[b]==array[i]) {
                    count++;
                    break;
                }

                else if(array[a]+array[b]<array[i])
                    a++;
                else
                    b--;
            }
        }
        System.out.println(count);
    }
}
