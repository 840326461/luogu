package string.P1200;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String ufo=s.nextLine();
        String group=s.nextLine();
        int a=1;
        int b=1;
        for (int i=0;i<ufo.length();i++) {
            a*=(ufo.charAt(i)-0x40);
        }
        for (int i=0;i<group.length();i++) {
            b*=(group.charAt(i)-0x40);
        }
        if (a%47==b%47){
            System.out.println("GO");
        }else
            System.out.println("STAY");
    }
}
