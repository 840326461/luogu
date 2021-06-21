package newer.bytedance;

import java.util.Scanner;

public class Main4 {
    
    static int ansdist;
    static int[][] edges;
    static boolean[] visited;
    static int shortnum;
    static int n;
    static int des=0;
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
         n = s.nextInt();
        edges = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges[i][j] = s.nextInt();
            }
        }
        visited=new boolean[n];
        DFS(0,0);

    }

    private static void DFS(int start, int dis) {
        int i, j;
        if(dis>ansdist) return;
        for (i = 0; i < n; i++) {
            if (!visited[i] && i != start) {
                if (dis + edges[start][i] > ansdist) continue;
                else if (i == des && dis + edges[start][i] == ansdist) {
                    shortnum++;
                    System.out.println(ansdist);
                } else {
                    visited[start] = true;
                    DFS(i, dis + edges[start][i]);
                    visited[start] = false;
                }
            }
        }
    }
}
