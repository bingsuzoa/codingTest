import java.util.*;
import java.io.*;

class Main {
    static int[][] dp;
    static boolean[] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1][N+1];


        String value = String.valueOf(N) + String.valueOf(N);
        int num = Integer.parseInt(value);
        primes = new boolean[num + 1];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for(int i = 2; i * i < primes.length; i++) {
            if(primes[i]) {
                for(int j = i * i; j < primes.length; j+= i) {
                    primes[j] = false;
                }
            }
        }

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[1][1] = 0;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(i == 1 && j == 1) continue;
                if(primes[getNum(i, j)]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[N][N]);
    }

    private static int getNum(int x, int y) {
        String temp = String.valueOf(x) + String.valueOf(y);
        return Integer.parseInt(temp);
    }
}