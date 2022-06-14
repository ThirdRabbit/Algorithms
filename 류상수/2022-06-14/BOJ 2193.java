import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(in.readLine());

        long[][] pinaryNumber = new long[N + 1][2];

        pinaryNumber[1][0] = 0;
        pinaryNumber[1][1] = 1;

        for (int index = 2; index <= N; index++) {
            pinaryNumber[index][0] = pinaryNumber[index - 1][0] + pinaryNumber[index - 1][1];
            pinaryNumber[index][1] = pinaryNumber[index - 1][0];
        }

        out.write(String.valueOf(pinaryNumber[N][0] + pinaryNumber[N][1]));

        in.close();
        out.flush();
        out.close();
    }
}