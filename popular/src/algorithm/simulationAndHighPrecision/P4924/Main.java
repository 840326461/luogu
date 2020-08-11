package algorithm.simulationAndHighPrecision.P4924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputReader s=new InputReader(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[][] matrix=new int[n][n];
        int count=1;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j]=count;
                count++;
            }
        }
        for(int i=0;i<m;i++){
            int x=s.nextInt();
            int y=s.nextInt();
            int r=s.nextInt();
            int z=s.nextInt();
            rotate(matrix,x-1,y-1,r,z);
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void rotate(int[][] matrix, int x,int y,int r,int z){
        int a;
        if(z==0) {
            for (int j = 1; j <= r; j++) {
                for (int i = 0; i < 2 * j; i++) {
                    a = matrix[x - j + i][y + j];
                    matrix[x - j + i][y + j] = matrix[x - j][y - j + i];
                    matrix[x - j][y - j + i] = matrix[x + j - i][y - j];
                    matrix[x + j - i][y - j] = matrix[x + j][y + j - i];
                    matrix[x + j][y + j - i] = a;
                }
            }
        }else{
            for (int j = 1; j <= r; j++) {
                for (int i = 0; i < 2 * j; i++) {
                    a = matrix[x - j + i][y + j];
                    matrix[x - j + i][y + j]=matrix[x + j][y + j - i];
                    matrix[x + j][y + j - i]=matrix[x + j - i][y - j];
                    matrix[x + j - i][y - j]=matrix[x - j][y - j + i];
                    matrix[x - j][y - j + i]=a;
                }
            }
        }
    }
}

class InputReader {
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