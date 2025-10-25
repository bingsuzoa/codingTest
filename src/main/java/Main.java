import java.util.*;
import java.io.*;

class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] graph = new int[N];
        dp = new int[1000001];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = Integer.parseInt(br.readLine());
            dp[graph[i]]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < graph.length; i++) {
            sb.append(check(graph[i])).append("\n");
        }
        System.out.println(sb);
    }
    private static int check(int num) {
        int count = 0;
        for(int n = 1; n <= (int)Math.sqrt(num); n++) {
            if(num % n == 0) {
                int m = num / n;
                if(n == m) {
                    count += dp[n];
                } else {
                    count += dp[n];
                    count += dp[m];
                }
            }
        }
        return count - 1;
    }
}