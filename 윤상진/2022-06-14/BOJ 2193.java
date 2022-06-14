package BOJ_20220614.BOJ_2193;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[][] d = new long[91][2];
        d[1][0] = 0;
        d[1][1] = 1;

        for(int i=2; i<=n; i++){
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][0];
        }

        System.out.println(d[n][0]+d[n][1]);

    }
}
