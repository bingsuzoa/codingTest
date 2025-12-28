import java.util.*;
import java.io.*;

class Main {
    static long MOD = 1000000000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        if(N == 1) {
            System.out.println(1);
            return;
        }
        if(N == 2) {
            System.out.println(2);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < dp.length; i++) {
            if(i % 2 == 0) {
                dp[i] = (dp[i - 1] + dp[i/2]) % MOD;
            } else {
                dp[i] = dp[i-1] % MOD;
            }
        }
        System.out.println(dp[N] % MOD);
    }
}