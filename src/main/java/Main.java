import java.util.*;
import java.io.*;

class Main {
    static int N,M;
    static int[][] graph;
    static int X;
    static int pos;
    static boolean[][] visited;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N][M];

        for(int i = 0; i < graph.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        X = Integer.parseInt(br.readLine());

        visited = new boolean[N][M];
        queue = new LinkedList<>();
        pos = graph[0][0];
        queue.add(new int[]{0,0});
        visited[0][0] = true;

        if(graph[N-1][M-1] != pos) {
            System.out.println("DEAD");
            return;
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int sx = cur[0];
            int sy = cur[1];

            if(sx == N-1 && sy == M-1) {
                System.out.println("ALIVE");
                return;
            }

            getMan(sx, sy);
        }

        System.out.println("DEAD");

    }
    private static void getMan(int sx, int sy) {
        for(int i = graph.length - 1; i >= 0; i--) {
            for(int j = graph[i].length -1; j >= 0; j--) {
                if(isMan(sx, sy, i, j) && graph[i][j] == pos && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
    }

    private static boolean isMan(int sx, int sy, int ex, int ey) {
        int length = Math.abs(sx - ex) + Math.abs(sy - ey);
        return length <= X;
    }
}