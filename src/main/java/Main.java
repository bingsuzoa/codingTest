import java.util.*;
import java.io.*;

class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        calculate(N, r, c);
        System.out.println(answer - 1);
    }

    private static void calculate(int N, int r, int c) {
        if(N == 1) {
            if(r == 0 && c == 0) answer += 1;
            else if(r == 0 && c == 1) answer += 2;
            else if(r == 1 && c == 0) answer += 3;
            else answer += 4;
            return;
        }

        int n = (int)Math.pow(2, N-1);

        if(r/n == 1 && c/n == 1) {
            answer += (n * n) * 3;
        }
        else if(r/n == 1 && c/n == 0) {
            answer += (n * n) * 2;
        }
        else if(r/n == 0 && c/n == 1) {
            answer += (n * n) * 1;
        }
        calculate(N-1, r%n, c%n);
    }
}