import java.io.*;
import java.util.StringTokenizer;


class Main {
    static long MOD = 1000000007;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new long[N+1];
        dp[0] = 1;

        for(int i = 1; i <= N; i++) {
            dp[i] = (dp[i-1] * i) % MOD;
        }

        long upper = dp[N];
        long bottom = (dp[K] * dp[N-K]) % MOD;

        System.out.println((upper * modPow(bottom, MOD - 2)) % MOD);
    }

    private static long modPow(long base, long exp) {
        long result = 1;
        while(exp > 0) {
            if((exp & 1) == 1) {
                result = (base * result) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}