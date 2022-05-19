import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(in.readLine());

        int[] pillars = new int[1001];
        int firstPillarIdx = 1000;
        int lastPillarIdx = 0;
        int highestPillarHeight = 0;
        int highestPillarNum = 0;
        int output = 0;

        for (int index = 0; index < N; index++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());

            int L = Integer.parseInt(tokenizer.nextToken());
            int H = Integer.parseInt(tokenizer.nextToken());

            pillars[L] = H;

            if (L < firstPillarIdx) {
                firstPillarIdx = L;
            }

            if (L > lastPillarIdx) {
                lastPillarIdx = L;
            }

            if (H > highestPillarHeight) {
                highestPillarHeight = H;
                highestPillarNum = 1;
            } else if (H == highestPillarHeight) {
                highestPillarNum++;
            }
        }

        int leftRightPillarIndex = firstPillarIdx;

        for (int index = firstPillarIdx + 1; index <= 1000; index++) {
            if (highestPillarNum == 0) {
                break;
            }

            if (pillars[index] != 0 && pillars[index] >= pillars[leftRightPillarIndex]) {
                if (pillars[index] == highestPillarHeight) {
                    highestPillarNum--;
                }

                output += (index - leftRightPillarIndex) * pillars[leftRightPillarIndex];
                leftRightPillarIndex = index;
            }
        }

        int rightLeftPillarIndex = lastPillarIdx;

        for (int index = lastPillarIdx - 1; index >= leftRightPillarIndex; index--) {
            if (pillars[index] != 0 && pillars[index] >= pillars[rightLeftPillarIndex]) {
                output += (rightLeftPillarIndex - index) * pillars[rightLeftPillarIndex];
                rightLeftPillarIndex = index;
            }
        }

        output += pillars[leftRightPillarIndex];

        out.write(String.valueOf(output));

        in.close();
        out.flush();
        out.close();
    }
}