import java.util.*;
import java.io.*;

class Main {
    static int[] graph;
    static int[] result;
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N];
        result = new int[N * 2];
        found = false;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph);
        Arrays.fill(result, -1);
        dfs(new boolean[N], 0);

        if(!found) {
            System.out.println(-1);
        }
    }

    private static void dfs(boolean[] visited, int cur) {
        if(found) {
            return;
        }

        if(cur == result.length) {
            found = true;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < result.length; i++) {
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        if(result[cur] != -1) {
            dfs(visited, cur + 1);
            return;
        }

        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                int pair = cur + graph[i] + 1;
                if(pair >= result.length || result[pair] != -1) {
                    continue;
                }
                visited[i] = true;
                result[cur] = result[pair] = graph[i];
                dfs(visited, cur + 1);
                result[cur] = result[pair] = -1;
                visited[i] = false;
                if(found) return;
            }
        }
    }
}