import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] graph;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0;j < input.length(); j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        dp = new int[1<<N][N][10];
        for(int i =0 ; i < dp.length; i++) {
            for(int j= 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        dfs(1, 0, 0);
        System.out.println(dp[1][0][0]);
    }
    private static int dfs(int visited, int artist, int price) {
        int count = dp[visited][artist][price];
        if(count != -1) {
            return count;
        }

        count = 0;
        for(int next = 1; next < N; next++) {
            if((visited & (1<<next)) == 0 && graph[artist][next] >= price) {
                int nextVisited = visited | (1<<next);
                count = Math.max(count, dfs(nextVisited, next, graph[artist][next]) + 1);
            }
        }
        return dp[visited][artist][price] = count;
    }
}