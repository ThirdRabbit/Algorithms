package BOJ_20220519.BOJ_13335;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int len = scanner.nextInt();
        int weight = scanner.nextInt();

        int[] truckWeight = new int[arrSize];
        int[] location = new int[arrSize];
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<arrSize; i++){
            truckWeight[i] = scanner.nextInt();
        }


        for(int i=0; i<arrSize; i++){
            if(queue.size() == 0){
                location[i]++;
                queue.add(i);
                result++;
            }else{
                for(int q : queue){
                    location[q]++;
                }
                result++;

                if (location[queue.peek()] == len + 1){
                    queue.remove();
                }

                int AlltruckWeight = 0;
                for(int q: queue){
                    AlltruckWeight += truckWeight[q];
                }
                while(queue.size() >= len || AlltruckWeight + truckWeight[i] > weight){

                    for(int q : queue){
                        location[q]++;
                    }
                    result++;

                    if (location[queue.peek()] == len + 1){
                        queue.remove();
                    }

                    AlltruckWeight = 0;
                    for(int q: queue){
                        AlltruckWeight += truckWeight[q];
                    }
                }
                location[i] ++;
                queue.add(i);
            }

        }


        while(queue.size() != 0 ){
            for(int q : queue){
                location[q]++;
            }
            result++;
            if (location[queue.peek()] == len + 1){
                queue.remove();
            }
        }

        System.out.println(result);
    }

}
