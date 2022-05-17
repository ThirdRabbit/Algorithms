import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int number = 0;
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder output = new StringBuilder("<");

        for (int index = 1; index <= N; index++) {
            queue.add(index);
        }

        while (!queue.isEmpty()) {
            if (number == K - 1) {
                output.append(queue.remove() + ", ");
            } else {
                queue.add(queue.remove());
            }

            number = (number + 1) % K;
        }

        output.setLength(output.length() - 2);
        output.append('>');

        out.write(output.toString());

        in.close();
        out.flush();
        out.close();
    }
}