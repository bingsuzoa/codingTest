import java.io.*;
import java.util.*;

class Main {
    static int s, N, K, R1, R2, C1, C2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        long size = (long)Math.pow(N, s);
        StringBuffer sb = new StringBuffer();
        for(int i = R1; i <= R2; i++) {
            for(int j = C1; j <= C2; j++) {
                if(isBlack(i, j, size)) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isBlack(int gx, int gy, long line) {
        long n = line / N;
        if(n < 1) {
            return false;
        }

        long start = ((N - K) / 2) * n;
        long end = start + (n * K);
        if(gx >= (int)start && gx < (int) end && gy >= (int) start && gy < (int) end) {
            return true;
        }

        return isBlack(gx %(int) n, gy % (int)n, n);

    }
}