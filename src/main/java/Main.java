import java.util.*;
import java.io.*;


class Main {
    static int[][] dp;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        while(t --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            set = new HashSet<>();
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            dp = new int[n + 1][n + 1];
            initSet(m, k, n);

            for(int i = 1; i < dp[0].length; i++) {
                if(!set.contains(i)) {
                    dp[1][i] = 1;
                }
            }

            for(int i = 2; i < dp.length; i++) {
                for(int j = i; j <dp[i].length; j++) {
                    for(int o = 1; o < j; o++) {
                        if(set.contains(o)) continue;
                        int pair = j - o;
                        dp[i][j] += dp[i-1][pair];
                    }
                }
            }

            int answer = 0;
            for(int i = 1; i < dp.length; i++) {
                answer += dp[i][n];
            }
            System.out.println(answer);
        }
    }

    private static void initSet(int m, int k, int n) {
        int i = 0;
        while(true) {
            int num = m + i * k;
            if(num <= n) {
                set.add(num);
                i++;
            } else {
                break;
            }

        }
    }
}