package BOJ_20220519.BOJ_2304;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = 0;
        int max_height = 0;
        int max_height_idx = 0;
        int last_height = 0;
        int result = 0;
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int i=0; i<t; i++){
            int idx = scanner.nextInt();
            int num = scanner.nextInt();
            start = start > idx ? idx : start;
            end = end < idx ? idx : end;

            max_height_idx = max_height < num ? idx : max_height_idx;
            max_height = max_height < num ? num : max_height;

            arr[idx] = num;
        }

        for(int i=start; i<= max_height_idx; i++){
            last_height = last_height < arr[i] ? arr[i] : last_height;
            result += last_height;
        }

        last_height = 0;
        for(int i=end; i > max_height_idx; i--){
            last_height = last_height < arr[i] ? arr[i] : last_height;
            result += last_height;
        }

        System.out.println(result);

    }
}
