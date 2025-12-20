import java.util.*;
import java.io.*;

class Main {
    static int N;
    static long M;
    static long[] graph;
    static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        graph = new long[N];

        for(int i = 0; i < graph.length; i++) {
            graph[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(graph);

        int left = 0;
        int right = 1;

        while(right < graph.length && left < graph.length) {
            if(graph[right] - graph[left] < M) {
                right++;
            } else {
                answer = Math.min(answer, graph[right] - graph[left]);
                left++;
            }
        }
        System.out.println(answer);
    }
}