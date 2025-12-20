import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] graph = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            graph[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < graph.length; i++){
            for(int j = 0; j <= i; j++) {
                int min = Integer.MAX_VALUE;
                int max = -1;
                for(int k = j; k <= i; k++) {
                    min = Math.min(graph[k], min);
                    max = Math.max(graph[k], max);
                }
                if(j == 0) {
                    dp[i] = Math.max(dp[i], max - min);
                } else {
                    dp[i] = Math.max(dp[i], dp[j-1] + max -min);
                }
            }
        }
        for(int value : dp) {
            System.out.print(value + " ");
        }
        System.out.println(dp[dp.length-1]);
    }
}