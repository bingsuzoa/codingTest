import java.util.*;
import java.io.*;

class Main {
    static int[] graph;
    static long[] graph2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N];
        graph2 = new long[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < graph.length; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < graph.length-1; i++) {
            graph2[i] = (long)Math.abs(graph[i] - graph[i+1]);
        }

        if(graph2.length == 1) {
            System.out.println(graph2[0]);
            return;
        }
        if(graph2.length == 2) {
            System.out.println(gcd(graph2[0], graph2[1]));
            return;
        }

        long result = gcd(graph2[0], graph2[1]);
        for(int i = 2; i < graph2.length; i++) {
            result = gcd(result, graph2[i]);
        }
        System.out.println(result);
    }

    private static long gcd(long a, long b) {
        while(b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}