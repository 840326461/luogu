package array.P1046;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int[] height=new int[10];
        for(int i=0;i<10;i++){
            height[i]=s.nextInt();
        }
        int tao=s.nextInt()+30;
        int count=0;
        for(int i=0;i<10;i++)
            if (tao>=height[i])count++;
        System.out.println(count);
    }
}
