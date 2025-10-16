import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] original;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        original = new int[N][N];

        for(int i = 0; i < original.length; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < original[i].length; j++) {
                original[i][j] = Integer.parseInt(input.nextToken());
            }
        }

        int[][] result = pow(original, B);

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                sb.append(result[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] pow(int[][] graph, long B) {
        if(B == 1L) {
            int[][] base = new int[N][N];
            for(int i =0 ; i < graph.length; i++) {
                for(int j = 0; j < graph[i].length; j++) {
                    base[i][j] = graph[i][j];
                }
            }
            return base;
        }

        int[][] ret = pow(graph, B/2);
        int[][] multi = multiply(ret, ret);

        if(B % 2 != 0) {
            return multiply(multi, original);
        }

        return multi;
    }

    private static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] result = new int[N][N];

        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                int sum = 0;
                for(int k = 0; k < N; k++) {
                    sum += (o1[i][k] * o2[k][j]) % 1000;
                }
                result[i][j] = sum % 1000;
            }
        }
        return result;
    }
}