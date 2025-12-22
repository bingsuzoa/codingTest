import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] graph = new int[M];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        List<Integer> list = new ArrayList<>();
        int people = 0;
        for(int value : graph) {
            if(value - people -1 == 0) {
                people = value;
                continue;
            }
            list.add(value - people - 1);
            people = value;
        }
        if(people < N) {
            list.add(N - people);
        }

        int sum = 1;
        for(int result : list) {
            sum *= dp[result];
        }
        System.out.println(sum);
    }
}