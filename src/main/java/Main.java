import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int N, M;
    static int[] dx = {1,-1,0,0, 1, 1, -1, -1};
    static int[] dy = {0,0,1,-1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        graph = new int[N][M];
        int max = 0;
        for(int i =0 ; i < graph.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, graph[i][j]);
            }
        }

        int count = 0;
        boolean[][] checked = new boolean[N][M];
        for(int n = max; n >= 1; n--) {
            for(int i = 0; i < graph.length; i++) {
                for(int j =0 ; j < graph[i].length; j++) {
                    if(graph[i][j] == n && !checked[i][j]) {
                        if(bfs(i, j, n)) {
                            check(i,j,n, checked);
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
    private static void check(int sx, int sy, int n, boolean[][] checked) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx,sy});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            checked[x][y] = true;

            for(int i =0 ; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                if(graph[nx][ny] == n && !checked[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean bfs(int sx, int sy, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        boolean[][] visited = new boolean[N][M];
        visited[sx][sy] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (graph[x][y] > n) {
                return false;
            }

            if (graph[x][y] < n) {
                continue;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= N || nx < 0 || ny >= M || ny < 0 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
        return true;
    }

}