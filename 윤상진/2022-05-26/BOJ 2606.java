package BOJ_20220526.BOJ_2606;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = 1;

        int[][] adjArray = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();

            adjArray[v1][v2] = 1;
            adjArray[v2][v1] = 1;
        }


        System.out.println(bfs(v,adjArray,visited));
    }

    public static int bfs(int v, int[][] adjArray, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty()){
            v = queue.poll();
            result+=1;

            for(int i=1; i<adjArray.length; i++){
                if(adjArray[v][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return result-1;
    }
}
