import java.io.*;

class Main {
    static int[] graph;
    static long[] dp;
    static int MOD = 1000000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        graph = new int[input.length()];
        for(int i = 0; i < input.length(); i++) {
            graph[i] = input.charAt(i) - '0';
        }

        dp = new long[input.length() + 1];
        init();

        for(int i = 3; i < dp.length; i++) {
            long befo = graph[i-2];
            long cur = graph[i-1];
            if(!checkOne(cur) && !checkTwo(befo, cur)) {
                System.out.println(0);
                return;
            }

            if(checkOne(cur)) {
                dp[i] += dp[i-1] % MOD;
            }
            if(checkTwo(befo, cur)) {
                dp[i] += dp[i-2] % MOD;
            }
            dp[i] %= MOD;
        }

        if(graph.length > 2) {
            System.out.println(dp[dp.length - 1] % MOD);
        }
    }

    private static boolean checkOne(long num) {
        if(num == 0L) {
            return false;
        }
        return true;
    }

    private static boolean checkTwo(long one, long two) {
        long num = one * 10 + two;
        if(num >= 10L && num <= 26L) {
            return true;
        }
        return false;
    }

    private static void init() {
        dp[0] = 1;
        if(graph.length == 0) {
            System.out.println(dp[0]);
            return;
        }

        if(checkOne(graph[0])) {
            dp[1] += dp[0];
        }
        if(graph.length == 1) {
            System.out.println(dp[1]);
            return;
        }

        if(checkOne(graph[1])) {
            dp[2] += dp[1];
        }
        if(checkTwo(graph[0], graph[1])) {
            dp[2] += dp[0];
        }
        if(graph.length == 2) {
            System.out.println(dp[2]);
        }
    }
}