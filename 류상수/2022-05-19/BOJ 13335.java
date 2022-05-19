import java.io.*;
import java.util.*;

class Truck {
    public int weight;
    public int time;

    public Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
}

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());

        Queue<Truck> readyQueue = new LinkedList<>();
        LinkedList<Truck> bridge = new LinkedList<>();
        int currentWeight = 0;
        int output = 0;

        tokenizer = new StringTokenizer(in.readLine());

        for (int index = 0; index < n; index++) {
            readyQueue.add(new Truck(Integer.parseInt(tokenizer.nextToken()), w));
        }

        Truck newTruck = readyQueue.remove();
        bridge.add(newTruck);
        currentWeight += newTruck.weight;

        while (!readyQueue.isEmpty() || !bridge.isEmpty()) {
            int time = 1;

            if (readyQueue.isEmpty() || currentWeight + readyQueue.peek().weight > L) {
                time = bridge.peek().time;
            }

            output += time;

            for (Truck truck : bridge) {
                truck.time -= time;
            }

            if (bridge.peek().time == 0) {
                currentWeight -= bridge.remove().weight;
            }

            if (!readyQueue.isEmpty() && currentWeight + readyQueue.peek().weight <= L) {
                newTruck = readyQueue.remove();
                bridge.add(newTruck);
                currentWeight += newTruck.weight;
            }
        }

        out.write(String.valueOf(output + 1));

        in.close();
        out.flush();
        out.close();
    }
}