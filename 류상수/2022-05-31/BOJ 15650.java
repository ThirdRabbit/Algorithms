import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void showCombination(int n, int m, int[] combination, int depth) throws IOException {
        if (depth == m) {
            for (int index = 0; index < combination.length; index++) {
                out.write(String.valueOf(combination[index]) + ' ');
            }

            out.write('\n');

            return;
        }

        for (int number = (depth == 0) ? (1) : (combination[depth - 1] + 1); number <= n; number++) {
            combination[depth] = number;
            showCombination(n, m, combination, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        showCombination(N, M, new int[M], 0);

        in.close();
        out.flush();
        out.close();
    }
}