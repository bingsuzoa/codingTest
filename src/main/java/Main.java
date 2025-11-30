import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[2][3];
        StringTokenizer first = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            dp[0][i] = Integer.parseInt(first.nextToken());
            dp[1][i] = dp[0][i];
        }

        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k =  Integer.parseInt(st.nextToken());

            int nn = Math.max(dp[0][0], dp[0][1]) + n;
            int mm = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])) + m;
            int kk = Math.max(dp[0][1], dp[0][2]) + k;
            dp[0][0] = nn;
            dp[0][1] = mm;
            dp[0][2] = kk;

            int nnn = Math.min(dp[1][0], dp[1][1]) + n;
            int mmm = Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2])) + m;
            int kkk = Math.min(dp[1][1], dp[1][2]) + k;
            dp[1][0] = nnn;
            dp[1][1] = mmm;
            dp[1][2] = kkk;
        }

        int maxAns = 0;
        int minAns = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            maxAns = Math.max(maxAns, dp[0][i]);
            minAns = Math.min(minAns, dp[1][i]);
        }
        System.out.println(maxAns + " " + minAns);
    }
}