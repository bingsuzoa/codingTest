import java.util.*;
import java.io.*;

class Main {
    static int MOD = 1000000000;
    static long[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new long[K + 1][N + 1];

        for(int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= N; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                long sum = 0;
                for(int k = 0; k <= j; k++) {
                    sum += (dp[i-1][j - k] * dp[1][k]) % MOD;
                }
                dp[i][j] = sum % MOD;
            }
        }

        System.out.println(dp[K][N] % MOD);
    }
}