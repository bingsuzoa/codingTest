import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] graph = new int[501][501];
    static boolean[][] visited = new boolean[501][501];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                for(int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
                    graph[j][k] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                for(int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
                    graph[j][k] = 2;
                }
            }
        }
        bfs();
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    private static void bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> {
            return o1[2] - o2[2];
        });
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if (x == 500 && y == 500) {
                answer = Math.min(answer, count);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= graph.length || nx < 0 || ny >= graph[0].length || ny < 0) {
                    continue;
                }
                if (graph[nx][ny] == 2) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (graph[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny, count + 1});
                } else if (graph[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny, count});
                }
            }
        }
    }
}