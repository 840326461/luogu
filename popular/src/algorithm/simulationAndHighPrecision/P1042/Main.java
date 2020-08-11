package algorithm.simulationAndHighPrecision.P1042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] raw = new char[2500 * 25];
        int length = br.read(raw);

        int a = 0;
        int b = 0;

        for (char c : raw) {


            if ((a >= 11 || b >= 11) && Math.abs(a - b) >= 2) {
                System.out.println(a + ":" + b);
                a = 0;
                b = 0;
            }

            if (c == 'E') {
                System.out.println(a + ":" + b);
                a = 0;
                b = 0;
                break;
            }

            if (c == 'W') {
                a++;
            } else if (c == 'L') {
                b++;
            }

        }
        System.out.println();
        for (char c : raw) {


            if ((a >= 21 || b >= 21) && Math.abs(a - b) >= 2) {
                System.out.println(a + ":" + b);
                a = 0;
                b = 0;
            }

            if (c == 'E') {
                System.out.println(a + ":" + b);
                break;
            }

            if (c == 'W') {
                a++;
            } else if (c == 'L') {
                b++;
            }

        }
    }
}
