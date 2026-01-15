import java.util.*;
import java.io.*;

class Main {
    static String input;
    static int N;
    static Map<Character, Integer> map;
    static int size;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        input = br.readLine();
        size = input.length();

        map = new HashMap<>();
        map.put('B', 0);
        map.put('L', 1);
        map.put('D', 2);

        dp = new int[size][size];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i], -1);
            }
        }

        System.out.println(dfs(0, size -1, 0));
    }

    private static int dfs(int left, int right, int need) {
        if(left > right) {
            return 0;
        }
        if(dp[left][right] != -1) {
            return dp[left][right];
        }

        int curL = map.get(input.charAt(left));
        int curR = map.get(input.charAt(right));
        int next = (need + 1) % 3;

        dp[left][right] = 0;

        if(curL == need) {
            dp[left][right] = Math.max(dp[left][right], dfs(left + 1, right, next) + 1);
        }
        if(curR == need) {
            dp[left][right] = Math.max(dp[left][right], dfs(left, right -1, next) + 1);
        }
        return dp[left][right];
    }
}