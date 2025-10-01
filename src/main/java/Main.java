import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][] graph;
    static int r1,c1,r2,c2, max;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        graph = new int[r2 - r1 + 1][c2 - c1 + 1];

        int x = 0;
        int y = 0;
        int num = 1;
        int cnt = 0;
        int dnum = 1;
        int dir = 0;

        max = 0;
        while(!isFinish()) {
            if(x - r1 >= 0 && y - c1 >= 0 && x - r1 < graph.length && y -c1 < graph[0].length) {
                graph[x- r1][y - c1] = num;
                max = Math.max(max, num);
            }
            num++;
            cnt++;
            x = x + dx[dir];
            y = y + dy[dir];

            if(cnt == dnum) {
                if(dir == 1 || dir == 3) dnum++;
                dir++;
                dir %= 4;
                cnt = 0;
            }
        }

        print();
    }

    private static boolean isFinish() {
        return graph[0][0] != 0 && graph[0][c2-c1] != 0 && graph[r2-r1][0] != 0 && graph[r2-r1][c2-c1] != 0;
    }

    private static void print() {
        int len = String.valueOf(max).length();

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                System.out.printf("%" + len + "d", graph[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
