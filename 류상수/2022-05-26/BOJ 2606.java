import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int computerNumber = Integer.parseInt(in.readLine());
        int networkPairNumber = Integer.parseInt(in.readLine());

        List<List<Integer>> networkPairs = new ArrayList<>();
        int output = 0;

        for (int index = 0; index < computerNumber + 1; index++) {
            networkPairs.add(new ArrayList<>());
        }

        for (int index = 0; index < networkPairNumber; index++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());

            int computer1 = Integer.parseInt(tokenizer.nextToken());
            int computer2 = Integer.parseInt(tokenizer.nextToken());

            networkPairs.get(computer1).add(computer2);
            networkPairs.get(computer2).add(computer1);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] virus = new boolean[computerNumber + 1];

        stack.push(1);
        virus[1] = true;

        while (!stack.isEmpty()) {
            List<Integer> networkPair = networkPairs.get(stack.pop());

            for (int computer : networkPair) {
                if (!virus[computer]) {
                    stack.push(computer);
                    virus[computer] = true;
                    output++;
                }
            }
        }

        out.write(String.valueOf(output));

        in.close();
        out.flush();
        out.close();
    }
}