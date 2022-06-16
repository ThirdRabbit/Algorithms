import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(in.readLine());
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(in.readLine());

        for (int index = 0; index < N; index++) {
            A.add(Integer.parseInt(tokenizer.nextToken()));
        }

        tokenizer = new StringTokenizer(in.readLine());

        for (int index = 0; index < N; index++) {
            B.add(Integer.parseInt(tokenizer.nextToken()));
        }

        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        int output = 0;

        for (int index = 0; index < N; index++) {
            output += A.get(index) * B.get(index);
        }

        out.write(String.valueOf(output));

        in.close();
        out.flush();
        out.close();
    }
}