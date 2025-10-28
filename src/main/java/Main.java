import java.util.*;
import java.io.*;

class Main {
    static int N,M;
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N * 2][M * 2];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = input.charAt(j % M);
            }
        }

        for(int i = N; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = graph[i-N][j];
            }
        }

        long[] answer = new long[26];
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for(char i = 'A'; i <= 'Z'; i++) {
            map.put(i, idx++);
        }

        int realN = graph.length;
        int realM = graph[0].length;
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                char c = graph[i][j];
                int cIdx = map.get(c);

                long count = (i + 1) * (j + 1) * (realN - i) * (realM - j);
                answer[cIdx] += count;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(long value : answer) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }
}