package perfectworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) {
        InputReader s = new InputReader(System.in);
        int n = s.nextInt();
        int[] ta = new int[n];
        int[] tb = new int[n];
        for (int i = 0; i < n; i++) {
            ta[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            tb[i] = s.nextInt();
        }
        Arrays.sort(ta);
        Arrays.sort(tb);
        int index=n-1;
        while(true){
            if (index==-1){
                System.out.println(-100*n);
                return;
            }
            if (ta[n-1]<tb[index]){
                index--;
            }else {
                break;
            }
        }
        int indexA=n-1;
        int score=0;
        for (int i=index;i>=0;i--){
            if(ta[indexA]>tb[i]){
                score+=100;
            }else if (ta[indexA]<tb[i]){
                score-=100;
            }
            indexA--;
        }
        int indexB=n-1;
        for (int i=0;i<=indexA;i++){
            if(ta[i]>tb[indexB]){
                score+=100;
            }else if (ta[i]<tb[indexB]){
                score-=100;
            }
            indexB--;
        }
        System.out.println(score);
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
