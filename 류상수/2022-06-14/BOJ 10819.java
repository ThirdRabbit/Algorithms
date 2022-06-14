import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int calculateMax(int[] numbers, int[] permutation, boolean[] selection, int max, int depth) {
        if (depth == numbers.length) {
            int sum = 0;

            for (int index = 0; index < numbers.length - 1; index++) {
                sum += Math.abs(permutation[index] - permutation[index + 1]);
            }

            if (sum > max) {
                max = sum;
            }

            return max;
        }

        for (int index = 0; index < numbers.length; index++) {
            if (!selection[index]) {
                permutation[depth] = numbers[index];
                selection[index] = true;

                max = calculateMax(numbers, permutation, selection, max, depth + 1);

                permutation[depth] = 0;
                selection[index] = false;
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(in.readLine());
        int[] numbers = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(in.readLine());

        for (int index = 0; index < N; index++) {
            numbers[index] = Integer.parseInt(tokenizer.nextToken());
        }

        out.write(String.valueOf(calculateMax(numbers, new int[N], new boolean[N], Integer.MIN_VALUE, 0)));

        in.close();
        out.flush();
        out.close();
    }
}