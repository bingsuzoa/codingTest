import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int[] nums = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 5};
    static long[][] dp;
    static long number;
    static int[] numbers;
    static int N;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        number = Long.parseLong(input);
        numbers = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        dp = putDp();
        N = input.length();

        /// 일의 자리
        long result = (long)Math.pow(10, N);
        int prefix = nums[numbers[N -1]];
        for(int d = 0; d < 10; d++) {
            if(prefix == nums[d] && numbers[N -1] < d) {
                result = Math.min(result, d - numbers[N-1]);
            }
            else if(prefix == nums[d] && numbers[N-1] >= d) {
                result = Math.min(result, (long)Math.pow(10, N) - numbers[N-1] + d);
            }
        }
        /// 십의 자리부터
        int count = nums[numbers[N-1]];
        for(int len = 2; len <= N; len ++) {
            long digit = number % (long)Math.pow(10, len);
            count += nums[numbers[N-len]];

            for(int num = 0; num < 10; num++) {
                if(count - nums[num] >= 0) {
                    long pows = num * (long)Math.pow(10, len-1);
                    long target = dp[len-1][count - nums[num]];
                    if(target != Long.MAX_VALUE && digit != (pows + target)) {
                        long value = pows + target - digit;
                        if(value <= 0) {
                            value += (long)Math.pow(10, N);
                        }
                        result = Math.min(result, value);
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static long[][] putDp() {
        long[][] dp = new long[15 + 1][15 * 7 + 1];

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        for(int d = 0; d <= 9; d++) {
            dp[1][nums[d]] = Math.min(dp[1][nums[d]], d);
        }

        for(int len = 2; len < dp.length; len++) {
            for(int sum = 0; sum < dp[len].length; sum++) {
                for(int d = 0; d <= 9; d++) {
                    if(sum - nums[d] < 0 || dp[len -1][sum - nums[d]] == Long.MAX_VALUE) continue;
                    long newNum = (long)(d * Math.pow(10, len -1)) + dp[len-1][sum-nums[d]];
                    dp[len][sum] = Math.min(dp[len][sum], newNum);
                }
            }
        }
        return dp;
    }

    private static long getNumber(int len) {
        int startIdx = numbers.length - len;

        int digit = len;
        long number = 0;
        for(int i = startIdx; i < numbers.length; i++) {
            number += numbers[i] * (long)Math.pow(10, digit-1);
            digit--;
        }
        return number;
    }

    private static int getSum(int len) {
        int sum = 0;
        int startIdx = numbers.length - len;

        for(int i = startIdx; i < numbers.length; i++) {
            sum += nums[numbers[i]];
        }
        return sum;
    }


}

