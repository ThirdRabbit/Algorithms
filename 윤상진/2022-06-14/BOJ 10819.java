package BOJ_20220614.BOJ_10819;

import java.util.Scanner;

public class Main {
    public static int[] nums;
    public static int[] arr;
    public static boolean[] visited;
    public static int result = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        nums = new int[n];
        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int depth){
        if (depth == nums.length) {
            int r = 0;
            for(int i=1; i< nums.length; i++){
                r += Math.abs(arr[i - 1] - arr[i]);
            }
            result = result < r ? r : result;
            return;
        }

        for(int i=0; i< nums.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                arr[depth] = nums[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
