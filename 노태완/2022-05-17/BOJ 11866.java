import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Josephus_11866 {

    public static void main(String[] args) throws IOException {
        //첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000) ex)7 3

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언

        StringTokenizer inputVal = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(inputVal.nextToken());
        int target = Integer.parseInt(inputVal.nextToken());

        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        for (int i = 1; i <= cnt; i++) {
            arr.addLast(i);
        }

        StringBuilder sb = new StringBuilder("<");
        while(!arr.isEmpty()) {
            for (int i = 0; i < target-1; i++) {
                int temp = arr.pop();
                arr.addLast(temp);
            }
            sb.append(arr.pop() + ", ");
        }
        int len = sb.length();
        sb = sb.delete(len-2, len); //마지막 ", " 삭제
        sb.append(">");
        System.out.print(sb);

        br.close();
    }
}
