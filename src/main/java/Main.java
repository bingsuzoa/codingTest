import java.util.*;
import java.io.*;

class Main {
    static long[] graph = new long[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        int pos = checkPos(N);
        setGraph();
        if(overK(N, k, pos)) {
            System.out.println(-1);
            return;
        }

        long sum = 0;
        int cur = 0;
        for(int i = 1; i < graph.length; i++) {
            cur = i;
            if(sum + graph[i] > k) {
                break;
            }
            sum += graph[i];
        }
        k -= sum;

        long quad = k / cur;
        long remain = k %  cur;

        long value = (long)Math.pow(10, cur-1);
        value = value + quad - 1;

        if(remain == 0) {
            System.out.println(value % 10);
            return;
        }
        value ++;
        String s = String.valueOf(value);
        System.out.println(s.charAt((int)(remain-1)));
    }

    private static boolean overK(long N, long k, int pos) {
        long sum = 0;
        for(int i= 1; i < pos; i++) {
            sum += graph[i];
        }
        long num = (long)Math.pow(10, pos-1);
        N = N - num + 1;
        sum += (N * pos);
        if(sum < k) {
            return true;
        }
        return false;
    }

    private static int checkPos(long N) {
        int pos = 0;
        while(true) {
            if(N / (long)Math.pow(10, pos) == 0) {
                break;
            }
            pos ++;
        }
        return pos;
    }

    private static void setGraph() {
        for(int i = 1; i < graph.length; i++) {
            long left = (long)Math.pow(10, i);
            long right = (long)Math.pow(10, i-1);
            graph[i] = (left - right) * i;
        }
    }

}