import java.io.*;
import java.util.*;

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
        int N = Integer.parseInt(in.readLine());

        boolean[][] map = new boolean[N][N];

        for (int row = 0; row < N; row++) {
            String line = in.readLine();

            for (int col = 0; col < N; col++) {
                if (line.charAt(col) == '1') {
                    map[row][col] = true;
                }
            }
        }

        Stack<Pos> stack = new Stack<>();
        boolean[][] search = new boolean[N][N];

        int complexNumber = 0;
        List<Integer> complexCount = new ArrayList<>();

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (map[row][col] && !search[row][col]) {
                    int count = 1;

                    stack.push(new Pos(col, row));
                    search[row][col] = true;

                    while (!stack.isEmpty()) {
                        Pos pos = stack.pop();

                        for (int index = 0; index < 4; index++) {
                            int x = pos.x + DX[index];
                            int y = pos.y + DY[index];

                            if (x >= 0 && x < N && y >= 0 && y < N && map[y][x] && !search[y][x]) {
                                count++;
                                stack.push(new Pos(x, y));
                                search[y][x] = true;
                            }
                        }
                    }

                    complexNumber++;
                    complexCount.add(count);
                }
            }
        }

        Collections.sort(complexCount);

        out.write(String.valueOf(complexNumber) + '\n');

        for (int index = 0; index < complexCount.size(); index++) {
            out.write(String.valueOf(complexCount.get(index)) + '\n');
        }

        in.close();
        out.flush();
        out.close();
    }
}