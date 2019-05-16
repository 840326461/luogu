package bytedance;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<>();
        while (s.hasNext()) {
            inputList.add(s.nextLine());
        }
        int n = inputList.size();
        int m = 0;
        int[][] map = new int[n][];
        int[][] nextState = new int[n][];
        for (int i = 0; i < inputList.size(); i++) {
            String[] row = inputList.get(i).split(" ");
            m = row.length;
            int[] intRow = new int[row.length];
            for (int j = 0; j < row.length; j++) {
                intRow[j] = Integer.parseInt(row[j]);
            }
            map[i] = intRow;
        }
        copy(map,nextState);

        int count=0;
        while (true) {
            boolean fourZero = true;
            boolean noManager=true;
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (map[a][b] != 1) {
                        continue;
                    }
                    noManager=false;
                    if (a - 1 >= 0) {
                        if (map[a - 1][b] !=0){
                            fourZero=false;
                            if (map[a - 1][b]==2){
                                nextState[a][b] = 2;
                            }
                        }

                    }
                    if (a + 1 < n) {
                        if (map[a + 1][b]!=0){
                            fourZero=false;
                            if (map[a + 1][b]==2){
                                nextState[a][b] = 2;
                            }
                        }
                    }
                    if (b - 1 >= 0) {
                        if (map[a][b - 1]!=0){
                            fourZero=false;
                            if (map[a][b - 1]==2){
                                nextState[a][b] = 2;
                            }
                        }

                    }
                    if (b + 1 < m ) {
                        if (map[a][b + 1]!=0){
                            fourZero=false;
                            if (map[a][b + 1]==2){
                                nextState[a][b] = 2;
                            }
                        }

                    }
                }
            }
            if (noManager){
                System.out.println(count);
                return;
            }

            if (fourZero){
                System.out.println(-1);
                return;
            }

            copy(nextState,map);
            count++;

        }

    }

    private static void copy(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            int[] temp = a[i];
            b[i]=new int[temp.length];
            System.arraycopy(temp, 0, b[i], 0, temp.length);
        }
    }
}
