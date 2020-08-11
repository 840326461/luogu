package algorithm.simulationAndHighPrecision.P1601;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        char[] aa=s.nextLine().toCharArray();
        char[] bb=s.nextLine().toCharArray();
        char[] a=new char[aa.length];
        char[] b=new char[bb.length];

        for(int i=0;i<a.length;i++){
            a[a.length-i-1]=aa[i];
        }
        for(int i=0;i<b.length;i++){
            b[b.length-i-1]=bb[i];
        }

        int min= Math.min(a.length, b.length);
        int max=Math.max(a.length,b.length);
        char[] mid=a.length>b.length?a:b;

        StringBuilder sb=new StringBuilder();
        int x;
        int z=0;

        for (int i=0;i<min;i++){
            x=a[i]-0x30+b[i]-0x30+z;
            sb.append(x%10);
            z=x/10;
        }

        for (int i=min;i<max;i++){
            x=mid[i]-0x30+z;
            sb.append(x%10);
            z=x/10;
        }
        if (z!=0){
            sb.append(z);
        }
        System.out.println(sb.reverse().toString());

    }
}
