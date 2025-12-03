import java.util.*;
import java.io.*;

class Main {
    static int M, N;
    static char[][] graph;
    static boolean[][][] visited;
    static int answer = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        M = Integer.parseInt(input.nextToken());
        N = Integer.parseInt(input.nextToken());

        graph = new char[M][N];
        for(int i = 0; i < M; i++) {
            String st = br.readLine();
            for(int j = 0; j < N; j++) {
                graph[i][j] = st.charAt(j);
            }
        }
        visited = new boolean[M][N][4];
        checkLine();
        checkVertical();
        System.out.println(answer);
    }

    private static void checkLine() {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N - 1; j++) {
                int lx = i;
                int ly = j;

                int rx = i;
                int ry = j + 1;

                for(int k = 0; k < 2; k++) {
                    int nlx = lx + dx[k];
                    int nly = ly + dy[k];
                    int nrx = rx + dx[k];
                    int nry = ry + dy[k];

                    if(isNotPossible(nlx, nly, k) || isNotPossible(nrx, nry, k)) {
                        continue;
                    }
                    if(graph[lx][ly] == 'X' && graph[rx][ry] == 'X' && graph[nlx][nly] == '.' && graph[nrx][nry] == '.') {
                        answer++;
                        makeTrue(lx, ly, rx, ry, nlx, nly, nrx, nry, k);
                    }
                }
            }
        }
    }

    private static void checkVertical() {
        for(int i =0 ; i < M - 1; i++) {
            for(int j = 0; j < N; j++) {
                int ux = i;
                int uy = j;

                int bx = i + 1;
                int by = j;

                for(int k = 2; k < 4; k++) {
                    int lux = ux + dx[k];
                    int luy = uy + dy[k];
                    int lbx = bx + dx[k];
                    int lby = by + dy[k];

                    if(isNotPossible(lux, luy, k) || isNotPossible(lbx, lby, k)) {
                        continue;
                    }

                    if(graph[ux][uy] == 'X' && graph[bx][by] == 'X' && graph[lux][luy] == '.' && graph[lbx][lby] == '.') {
                        answer++;
                        makeTrue(ux, uy, bx, by, lux, luy, lbx, lby, k);
                    }
                }
            }
        }
    }
    private static void makeTrue(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int k) {
        visited[x1][y1][k] = true;
        visited[x2][y2][k] = true;
        visited[x3][y3][k] = true;
        visited[x4][y4][k] = true;
    }

    private static boolean isNotPossible(int x, int y, int k) {
        if(x < 0 || y < 0 || x >= M || y >= N) {
            return true;
        }
        if(visited[x][y][k]) {
            return true;
        }
        return false;
    }
}