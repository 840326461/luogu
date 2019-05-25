package array.P1047;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int m = s.nextInt();
        int[] trees = new int[l + 1];
        int count = 0;
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            for (int j = a; j <= b; j++) {
                if (trees[j] != 1) {
                    count++;
                    trees[j]=1;
                }
            }
        }
        System.out.println(l+1-count);
    }
}
