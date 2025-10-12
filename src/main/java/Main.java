import java.util.*;
import java.io.*;

class Main {
    static int[] nums = new int[]{6,2,5,5,4,5,6,3,7,5};
    static long[][] dp;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        dp = new long[15+1][15*7+1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;

        for(int pos = 1; pos < dp.length; pos++) {
            for(int sum = 1; sum < dp[pos].length; sum++) {
                for(int j = 0; j < 10; j++) {
                    if(sum - nums[j] < 0 || dp[pos-1][sum - nums[j]] == Long.MAX_VALUE) continue;
                    long now = ((long)Math.pow(10, pos-1) * j) + dp[pos-1][sum - nums[j]];
                    dp[pos][sum] = Math.min(dp[pos][sum], now);
                }
            }
        }

        ///정답
        long answer = Long.MAX_VALUE;

        ///일의 자리
        int oneNum = input.charAt(input.length() - 1) - '0';
        int oneGoal = getSum(1);
        for(int i = 0; i < 10; i++) {
            if(oneGoal == nums[i]) {
                if(oneNum < i) {
                    answer = Math.min(answer, i - oneNum);
                } else {
                    answer = Math.min(answer, (long)Math.pow(10, input.length()) - oneNum + i);
                }
            }
        }

        ///십의 자리 부터
        if(input.length() -2 < 0) {
            System.out.println(answer);
            return;
        }

        for(int i = input.length() - 2; i >= 0; i--) {
            int pos = input.length() - i;

            int goal = getSum(pos);
            long num = getNum(pos);

            for(int n = 0; n < 10; n++) {
                int needSum = goal - nums[n];
                if(needSum < 0 || dp[pos -1][needSum] == Long.MAX_VALUE) continue;

                long now = n * (long) Math.pow(10, pos - 1) + dp[pos - 1][needSum];
                if(num < now) {
                    answer = Math.min(answer, now - num);
                } else {
                    answer = Math.min(answer, (long) Math.pow(10, input.length()) - num + now);
                }
            }
        }

        System.out.println(answer);
    }

    private static int getSum(int pos) {
        int sum = 0;
        int N = input.length();
        for(int i = N - pos; i < input.length(); i++) {
            sum += nums[input.charAt(i) - '0'];
        }
        return sum;
    }

    private static long getNum(int pos) {
        int N = input.length();

        long result = 0;
        long rec = pos - 1;
        for(int i = N - pos; i < input.length(); i++) {
            int c = input.charAt(i) - '0';
            result += (long)Math.pow(10, rec) * c;
            rec--;
        }
        return result;
    }

}