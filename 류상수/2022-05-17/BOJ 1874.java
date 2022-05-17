import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());

        int top = 0;
        boolean[] isPopped = new boolean[n];
        StringBuilder output = new StringBuilder();

        for (int index = 0; index < n; index++) {
            int number = Integer.parseInt(in.readLine()) - 1;

            if (isPopped[number]) {
                output = new StringBuilder("NO");

                break;
            }

            for (; top <= number; top++) {
                if (!isPopped[top]) {
                    output.append("+\n");
                }
            }

            for (; top > number; top--) {
                if (!isPopped[top - 1]) {
                    isPopped[top - 1] = true;
                    output.append("-\n");
                }
            }
        }

        out.write(output.toString());

        in.close();
        out.flush();
        out.close();
    }
}