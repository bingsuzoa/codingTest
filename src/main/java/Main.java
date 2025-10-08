import java.util.*;
import java.io.*;

class Main {
    static int N,M;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            int idx = 0;
            for(char c : input.toCharArray()) {
                graph[i][idx++] = c -'0';
            }
        }

        int[][] leftDown = new int[N][M];
        int[][] rightDown = new int[N][M];
        int[][] leftUp = new int[N][M];
        int[][] rightUp = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 1) {
                    leftDown[i][j] = 1;
                    rightDown[i][j] = 1;
                    if(i - 1 >= 0 && j - 1 >= 0) leftDown[i][j] += leftDown[i-1][j-1];
                    if(i -1 >= 0 && j + 1 < M) rightDown[i][j] += rightDown[i-1][j+1];
                }
            }
        }

        for(int i = N-1; i >= 0; i--) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 1) {
                    leftUp[i][j] = 1;
                    rightUp[i][j] = 1;
                    if(i + 1 < N && j - 1 >= 0) leftUp[i][j] += leftUp[i+1][j-1];
                    if(i +1 < N && j + 1 < M) rightUp[i][j] += rightUp[i+1][j+1];
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int maxSize = Math.min(leftDown[i][j], rightDown[i][j]);
                for(int size = maxSize; size > answer; size--) {
                    int top = i - 2 * (size - 1);
                    if(top < 0) continue;
                    if(leftUp[top][j] >= size && rightUp[top][j] >= size) {
                        answer = Math.max(answer, size);
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}