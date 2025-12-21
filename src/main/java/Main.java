import java.util.*;
import java.io.*;

class Main {
    static int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long sum = 0;
        for(long i = 2; i <= N / 2; i++) {
            long count = N / i - 1;
            sum += (i * count) % MOD;
        }
        System.out.println(sum % MOD);
    }
}