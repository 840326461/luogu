package newer.simplesimulation.P1563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputReader s = new InputReader(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] directions = new int[n];
        String[] toys = new String[n];
        for (int i = 0; i < n; i++) {
            directions[i]=s.nextInt();
            toys[i] = s.next();
        }
        int index = 0;
        for (int i = 0; i < m; i++) {
            if ((s.nextInt() ^ directions[index]) == 1) {
                index=(index+s.nextInt())%n;
            }else {
                index=index-s.nextInt()%n;
                if (index<0){
                    index+=n;
                }
            }
        }
        System.out.print(toys[index]);
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
