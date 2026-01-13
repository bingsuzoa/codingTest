import java.util.*;
import java.io.*;

class Main {
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N];

        for(int i = 0; i < graph.length; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(graph);

        long count = graph[0] - 1;
        graph[0] = 1;

        for(int i = 1; i < graph.length; i++) {
            int next = graph[i-1] + 1;

            if(graph[i] >= next) {
                count += graph[i] - next;
                graph[i] = next;
            }
        }
        System.out.println(count);
    }
}