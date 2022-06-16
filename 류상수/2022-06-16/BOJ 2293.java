import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] coins = new int[n];

        int[][] table = new int[k + 1][n];

        for (int index = 0; index < n; index++) {
            coins[index] = Integer.parseInt(in.readLine());

            if (coins[index] <= k) {
                table[coins[index]][index] = 1;
            }
        }

        for (int value = 1; value < k + 1; value++) {
            for (int index = 0; index < n; index++) {
                int prevValue = value - coins[index];

                if (index > 0) {
                    table[value][index] += table[value][index - 1];
                }

                if (prevValue > 0) {
                    table[value][index] += table[prevValue][n - 1];

                    if (index > 0) {
                        table[value][index] -= table[prevValue][index - 1];
                    }
                }
            }
        }

        out.write(String.valueOf(table[k][n - 1]));

        in.close();
        out.flush();
        out.close();
    }
}