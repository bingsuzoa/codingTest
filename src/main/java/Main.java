import java.util.*;
import java.io.*;

class Main {
    static long minSum = Long.MAX_VALUE;
    static long[] graph = new long[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if(A == B) {
            System.out.println(A + " " + B);
            return;
        }
        fillGraph(B / A);

        System.out.println(A * graph[0] + " " + A * graph[1]);
    }

    private static void fillGraph(int B) {
        for(int i = 1; i <= B/ 2; i++) {
            if(B % i != 0) continue;
            int pair = B / i;
            long tempSum = i + pair;
            if(gcd(i, pair) == 1 && minSum > tempSum) {
                graph[0] = i;
                graph[1] = pair;
                minSum = tempSum;
            }
        }
    }

    private static int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}