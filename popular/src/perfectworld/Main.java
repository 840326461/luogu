package perfectworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    static int m;
    static int min;

    public static void main(String[] args) {
        InputReader s = new InputReader(System.in);
        n = s.nextInt();
        m = s.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = s.nextInt();
            }
        }
        min = Integer.MAX_VALUE;
        DFS(n - 1, m - 1, 1);
        if (min < 0) System.out.println(0);
        else System.out.println(min);
    }

    private static void DFS(int a, int b, int hp) {
        if (a == 0 && b == 0) {
            hp -= map[a][b];
            if (hp < min) min = hp;
        }
        hp -= map[a][b];
        if (hp <= 0) hp = 1;
        if (a > 0) {
            DFS(a - 1, b, hp);
        }
        if (b > 0) {
            DFS(a, b - 1, hp);
        }
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
