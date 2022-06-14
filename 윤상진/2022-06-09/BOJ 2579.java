package BOJ_20220609.BOJ_2579;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static int[] d;
    public static int[] arr;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        arr = new int[n+1];
        d = new int[n+1];

        for(int i=1; i< n+1; i++){
            arr[i] = scanner.nextInt();
        }


        d[1] = arr[1];

        if (n >= 2) {
            d[2] = arr[1] + arr[2];
        }

        if (n >= 3) {
            d[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
        }

        for(int i=4; i<=n; i++){
            d[i] = Math.max(d[i-2]+arr[i], arr[i-1]+d[i-3]+arr[i]);
        }
        System.out.println(d[n]);
    }
}
