import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[K];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(graph);

        int re1 = graph[0];
        int re2 = N - graph[K-1];

        int answer = Math.max(re1, re2);

        for(int i = 0; i < graph.length - 1; i++) {
            answer = Math.max(answer, (graph[i+1] - graph[i]) / 2);
        }
        System.out.println(answer);
    }


}