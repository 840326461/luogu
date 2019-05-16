package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main3 {
    static int[][] map;
    static long[][] stateMap;
    static long result;
    static int n;
    static int m;
    static int c;
    static int d;

    public static void main(String[] args) {
        result = 0;
        InputReader s = new InputReader(System.in);
        n = s.nextInt();
        m = s.nextInt();
        map = new int[n][m];
        stateMap = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = s.nextInt();
                stateMap[i][j] = -1;
            }
        }
        int a = s.nextInt();
        int b = s.nextInt();
        c = s.nextInt();
        d = s.nextInt();
//        long t=next(a, b);
        System.out.println(next(a, b) % 1000000000);
    }

    private static long next(int a, int b) {
        if(map[a][b]==map[c][d])
            return 0;
        long count = 0;
        if (a - 1 >= 0 && map[a][b] < map[a - 1][b]) {
            if (stateMap[a - 1][b] != -1) {
                count += stateMap[a - 1][b];
            } else if (a - 1 == c && b == d) {
//                result++;
                count++;
            } else {
                count += next(a - 1, b);
            }
        }
        if (a + 1 < n && map[a][b] < map[a + 1][b]) {
            if (stateMap[a + 1][b] != -1) {
                count += stateMap[a + 1][b];
            } else if (a + 1 == c && b == d) {
//                result++;
                count++;
            } else {
                count += next(a + 1, b);
            }
        }
        if (b - 1 >= 0 && map[a][b] < map[a][b - 1]) {
            if (stateMap[a][b - 1] != -1) {
                count += stateMap[a][b - 1];
            } else if (a == c && b - 1 == d) {
//                result++;
                count++;
            } else {
                count += next(a, b - 1);
            }
        }
        if (b + 1 < m && map[a][b] < map[a][b + 1]) {
            if (stateMap[a][b + 1] != -1) {
                count += stateMap[a][b + 1];
            } else if (a == c && b + 1 == d) {
//                result++;
                count++;
            } else {
                count += next(a, b + 1);
            }
        }
        stateMap[a][b] = count;
        return count;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
