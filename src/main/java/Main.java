import java.util.*;
import java.io.*;

class Main {
    static int[] costs;
    static int[] graph;
    static int[][] dp;
    static int n,m,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            costs = new int[m+1];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                costs[j] = Integer.parseInt(st1.nextToken());
            }

            graph = new int[n];
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < graph.length; j++) {
                graph[j] = Integer.parseInt(st2.nextToken());
            }

            dp = new int[n][m+1];
            for(int j = 0; j < dp.length; j++) {
                Arrays.fill(dp[j], 1_000_000_000);
            }

            sb.append(dfs(0,0)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    private static int dfs(int cur, int save) {
        if(cur == n) {
            return 0;
        }

        if(dp[cur][save] != 1_000_000_000) return dp[cur][save];

        int ref = 1_000_000_000;
        if(save == graph[cur]) {
            ref = Math.min(ref, dfs(cur + 1, save));
        } else {
            // area1에 안옮겨
            ref = Math.min(ref, dfs(cur + 1, save) + costs[graph[cur]]);
            ref = Math.min(ref, dfs(cur + 1, graph[cur]) + c);
        }
        return dp[cur][save] = Math.min(dp[cur][save], ref);
    }
}