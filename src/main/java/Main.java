import java.io.*;
import java.util.*;

class Main {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int i = 2; i < 10; i++) {
            if(isPrime(i)) {
                dfs(i, 1);
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static void dfs(int num, int len) {
        if(len == N) {
            sb.append(num).append("\n");
            return;
        }
        num *= 10;
        for(int i = 0; i < 10; i++) {
            int result = num + i;
            if(isPrime(result)) {
                dfs(result, len + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}