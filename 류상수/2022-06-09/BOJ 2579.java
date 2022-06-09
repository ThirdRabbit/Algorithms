import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int ONE_STEP_MOVE = 0;
        final int TWO_STEP_MOVE = 1;

        int stairNumber = Integer.parseInt(in.readLine());
        int[] scores = new int[stairNumber];
        int[][] maxScores = new int[stairNumber][2];

        for (int index = 0; index < stairNumber; index++) {
            scores[index] = Integer.parseInt(in.readLine());
            maxScores[index][ONE_STEP_MOVE] = scores[index];
            maxScores[index][TWO_STEP_MOVE] = scores[index];
        }

        if (stairNumber >= 2) {
            maxScores[1][ONE_STEP_MOVE] += scores[0];
        }

        for (int index = 2; index < stairNumber; index++) {
            maxScores[index][ONE_STEP_MOVE] += maxScores[index - 1][TWO_STEP_MOVE];
            maxScores[index][TWO_STEP_MOVE] += Math.max(maxScores[index - 2][ONE_STEP_MOVE], maxScores[index - 2][TWO_STEP_MOVE]);
        }

        out.write(String.valueOf(Math.max(maxScores[stairNumber - 1][ONE_STEP_MOVE], maxScores[stairNumber - 1][TWO_STEP_MOVE])));

        in.close();
        out.flush();
        out.close();
    }
}