import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] graph;
    static int[] order;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < graph.length; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        order = new int[N];
        perm(0,new boolean[N]);
        System.out.println(max);
    }

    private static void perm(int cnt, boolean[] visited) {
        if(order.length == cnt) {
            check();
            return;
        }

        for(int i = 0; i < graph.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            order[cnt] = graph[i];
            perm(cnt + 1, visited);
            visited[i] = false;
        }
    }

    private static void check() {
        int[] prefix = new int[graph.length * 2 + 1];
        for(int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + order[(i - 1) % N];
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j <= i + N; j++) {
                if(prefix[j] - prefix[i] == 50)count++;
            }
        }
        max = Math.max(count/2, max);
    }

}