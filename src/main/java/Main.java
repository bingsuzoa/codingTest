import java.util.*;
import java.io.*;

class Main {
    static double N, M;
    static double[][][] dp;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()) * 0.01;
        M = Integer.parseInt(br.readLine()) * 0.01;

        dp = new double[19][19][19];
        init();

        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);

        double result = 0;
        for(int i = 0; i < dp[18].length; i++) {
            for(int j = 0; j < dp[18][i].length; j++) {
                if(set.contains(i) || set.contains(j)) {
                    result += dp[18][i][j];
                }
            }
        }
        System.out.printf("%.7f", result);
    }

    private static void init() {
        dp[0][0][0] = 1.0;

        for(int round = 1; round < dp.length; round++) {
            for(int n = 0; n <= round; n++) {
                for(int m = 0; m <= round; m++) {
                    //n 골, m 골
                    if(n - 1 >= 0 && m - 1 >= 0) {
                        dp[round][n][m] += dp[round-1][n-1][m-1] * N * M;
                    }
                    //n 골, m 무골
                    if(n - 1 >= 0) {
                        dp[round][n][m] += dp[round-1][n-1][m] * (N) * (1 - M);
                    }
                    //무골, 골
                    if(m-1 >= 0) {
                        dp[round][n][m] += dp[round-1][n][m-1] * (1-N) * M;
                    }
                    //무골 무골
                    dp[round][n][m] += dp[round-1][n][m] * (1-N)* (1-M);
                }
            }
        }
    }
}