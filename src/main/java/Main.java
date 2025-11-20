import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main {
    static int[] graph;
    static int[] prefix;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[125];
        prefix = new int[125];
        dp = new int[N + 1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = graph[i - 1] + i;
        }
        prefix[1] = graph[1];
        for (int i = 2; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + graph[i];
        }

        Arrays.fill(dp, 300000);
        dp[1] = 1;
        dp[0] = 0;
        for(int i = 2; i < dp.length; i++) {
            for(int j = 1; j < prefix.length; j++) {
                if(i - prefix[j] < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - prefix[j]] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}