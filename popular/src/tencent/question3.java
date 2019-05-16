package tencent;

import java.util.Scanner;

public class question3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int diff = n - k;
        int result = 0;
        for (int i = 0; i <= diff; i++) {
            int temp = C(diff, i);
            result += temp * temp;
        }
        System.out.println(result * 2);
    }

    private static int A(int n, int m) {
        int result = 1;
        for (int i = m; i > 0; i--) {
            result *= n;
            n--;
        }
        return result;
    }

    private static int C(int n, int m) {
        int helf = n / 2;
        if (m > helf) {
            m = n - m;
        }
        int numerator = A(n, m);
        int denominator = A(m, m);
        return numerator / denominator;
    }
}
