import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken()) + 1;

        long[][] dp = new long[51][51];

        dp[0][0] = 1;
        for(int len = 1; len <= 50; len++) {
            for(int bal = 0; bal <= 50; bal++) {
                if(bal + 1 <=50) dp[len][bal] += dp[len-1][bal+1];
                if(bal -1 >= 0) dp[len][bal] += dp[len-1][bal-1];
            }
        }
        long total = (long)Math.pow(2, N);
        long valid = dp[N][0];
        if(K > total - valid) {
            System.out.println(-1);
            return;
        }

        char[] result = new char[N];
        int bal = 0;
        for(int pos = 0; pos < result.length; pos++) {
            if(bal < 0) {
                long cur = (long)Math.pow(2, N-pos-1);
                if(cur < K) {
                    result[pos] = ')';
                    K -= cur;
                } else {
                    result[pos] = '(';
                }

            } else {
                long cur = (long)Math.pow(2, N-pos-1) - dp[N-pos-1][bal + 1];
                if(cur < K) {
                    result[pos] = ')';
                    bal--;
                    K -= cur;
                } else {
                    result[pos] = '(';
                    bal++;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(char c : result) {
            sb.append(c);
        }
        System.out.println(sb);


    }



}
