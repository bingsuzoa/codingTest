import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        graph = new int[N];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph);

        boolean[] checked = new boolean[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[2] - o1[2];
        });

        for(int i = 0; i < graph.length-1; i++) {
            pq.add(new int[]{i, i+1, graph[i+1] - graph[i]});
        }

        while(!pq.isEmpty()) {
            if(K > 1) {
                pq.poll();
                K--;
            } else {
                break;
            }
        }

        int sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll()[2];
        }
        System.out.println(sum);
    }
}