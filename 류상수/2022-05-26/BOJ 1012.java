import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {-1, 0, 1, 0};

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());

            int M = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());
            int K = Integer.parseInt(tokenizer.nextToken());

            boolean[][] field = new boolean[N][M];
            boolean[][] larva = new boolean[N][M];
            List<Pos> cabbagePos = new ArrayList<>();
            int output = 0;

            for (int index = 0; index < K; index++) {
                tokenizer = new StringTokenizer(in.readLine());

                int X = Integer.parseInt(tokenizer.nextToken());
                int Y = Integer.parseInt(tokenizer.nextToken());

                field[Y][X] = true;
                cabbagePos.add(new Pos(X, Y));
            }

            int index = 0;

            do {
                Pos pos = cabbagePos.get(index++);

                if (!larva[pos.y][pos.x]) {
                    Stack<Pos> stack = new Stack<>();

                    larva[pos.y][pos.x] = true;
                    output += 1;
                    stack.push(pos);

                    while (!stack.isEmpty()) {
                        pos = stack.pop();

                        for (int dir = 0; dir < 4; dir++) {
                            int x = pos.x + DX[dir];
                            int y = pos.y + DY[dir];

                            if (x >= 0 && x < M && y >= 0 && y < N) {
                                if (field[y][x] && !larva[y][x]) {
                                    larva[y][x] = true;
                                    stack.push(new Pos(x, y));
                                }
                            }
                        }
                    }
                }
            } while (index < cabbagePos.size());

            out.write(String.valueOf(output) + '\n');
        }

        in.close();
        out.flush();
        out.close();
    }
}