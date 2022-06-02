package BOJ_20220526.BOJ_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int result = 0;

        int[][] map = new int[m][n];
        List<Pair> pairList = new ArrayList<>();
        for(int i=0; i<k; i++){
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            map[num1][num2] = 1;
            pairList.add(new Pair(num1, num2));
        }

        for(Pair pair: pairList){
            if(map[pair.getNum1()][pair.getNum2()] == 1){
                dfs(pair.getNum1(),pair.getNum2(), map);
                result++;
            }

        }
        System.out.println(result);
    }

    public static class Pair{
        private int num1;
        private int num2;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        public int getNum1() {
            return num1;
        }

        public void setNum1(int num1) {
            this.num1 = num1;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }
    }

    public static void dfs(int num1, int num2, int[][] map){
        if(map[num1][num2] == 1){
            map[num1][num2] =0;
            if(num1 + 1 < map.length ){
                dfs(num1+1, num2, map);
            };
            if(num1 - 1 >= 0 ){
                dfs(num1-1, num2, map);
            };
            if(num2 + 1 < map[0].length ){
                dfs(num1, num2+1, map);
            };
            if(num2 - 1 >= 0 ){
                dfs(num1, num2-1, map);
            };
        }
    }


}
