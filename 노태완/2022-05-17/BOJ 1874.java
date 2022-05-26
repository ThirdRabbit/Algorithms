import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class StackSequence_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        ArrayDeque<String> output = new ArrayDeque<String>();

        int inputCnt = Integer.parseInt(br.readLine());
        int max = 0;

        for (int i = 0; i < inputCnt; i++) {
            int target = Integer.parseInt(br.readLine());

            if(arr.contains(target)) {
                if(arr.peekLast() == target) {
                    arr.removeLast();
                    output.addLast("-");
                    if(arr.isEmpty()) continue;
                }else {
                    output.addLast("no");
                }
            }else {
                int moveCnt = target - max;
                for (int j = 0; j < moveCnt; j++) {
                    arr.addLast(max+1);
                    max++;
                    output.addLast("+");
                }
                arr.removeLast();
                output.addLast("-");
                if(target > max) max = target;
            }
        }
        br.close();
        if(output.contains("no")) {
            System.out.println("NO");
        }else {
            int x = output.size();
            for (int i = 0; i < x; i++) {
                System.out.println(output.pop());
            }
        }
    }
}
