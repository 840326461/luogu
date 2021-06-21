package dp.P1002;

import java.util.Scanner;

public class Main {
    private long[][] board;

    public static void main(String[] args) {
        System.out.println(new Main().execute());
    }

    private long execute() {
        Scanner s = new Scanner(System.in);
        int bx = s.nextInt();
        int by = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        board = new long[bx + 1][by + 1];
        for (long[] i : board) {
            for (int j=0;j<by+1;j++) {
                i[j] = 0;
            }
        }
        if (x + 1 <= bx && y + 2 <= by)
            board[x + 1][y + 2] = -1;
        if (x + 1 <= bx && y - 2 >= 0)
            board[x + 1][y - 2] = -1;
        if (x - 1 >= 0 && y + 2 <= by)
            board[x - 1][y + 2] = -1;
        if (x - 1 >= 0 && y - 2 >= 0)
            board[x - 1][y - 2] = -1;
        if (x + 2 <= bx && y + 1 <= by)
            board[x + 2][y + 1] = -1;
        if (x + 2 <= bx && y - 1 >= 0)
            board[x + 2][y - 1] = -1;
        if (x - 2 >= 0 && y + 1 <= by)
            board[x - 2][y + 1] = -1;
        if (x - 2 >= 0 && y - 1 >= 0)
            board[x - 2][y - 1] = -1;
        if(board[0][0]==-1){
            return 0;
        }
        board[0][0]=1;
        board[x][y]=-1;
        return paths(bx, by);
    }

    private long paths(int a, int b) {
        if (board[a][b] == -1) {
            return 0;
        } else if (board[a][b] == 0) {
            long result = 0;
            if (a - 1 >= 0 && board[a - 1][b] != -1) {
                result += paths(a - 1, b);
            }
            if (b - 1 >= 0 && board[a][b - 1] != -1) {
                result += paths(a, b - 1);
            }
            board[a][b] = result;
            return result;
        } else {
            return board[a][b];
        }
    }
}
