import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int calculateSubsequenceNumber(int s, int[] numbers, int index, int sum, int output) {
        if (index == numbers.length) {
            return output;
        }

        while (index < numbers.length) {
            if (sum + numbers[index] == s) {
                output++;
            }

            output = calculateSubsequenceNumber(s, numbers, index + 1, sum + numbers[index], output);
            index++;
        }

        return output;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());
        int[] numbers = new int[N];

        tokenizer = new StringTokenizer(in.readLine());

        for (int index = 0; index < N; index++) {
            numbers[index] = Integer.parseInt(tokenizer.nextToken());
        }

        out.write(String.valueOf(calculateSubsequenceNumber(S, numbers, 0, 0, 0)));

        in.close();
        out.flush();
        out.close();
    }
}