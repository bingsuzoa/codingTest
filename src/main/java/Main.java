import java.util.*;
import java.io.*;


class Main {
    static int[] dp;
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
            dp = new int[n + 1];
            initSet(m, k, n);

            for(int i = 0; i < dp.length; i++) {
                if(!set.contains(i)) {
                    dp[i] = 1;
                }
            }

            for(int i = 2; i < dp.length; i++) {
                for(int j = 1; j < i; j++) {
                    if(set.contains(j)) continue;
                    dp[i] += dp[i - j];
                }
            }

            System.out.println(dp[n]);
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