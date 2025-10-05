import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[][] graph;
    static long answer;

    public static void main(String[] args) throws IOException {
        answer = -1L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i = 0; i < graph.length; i++) {
            String input = br.readLine();
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        for(int idst = -N; idst < N; idst++) {
            for(int jdst = -M; jdst < M; jdst++) {
                for(int i = 0; i < graph.length; i++) {
                    for(int j = 0; j < graph[i].length; j++) {
                        bfs(idst, jdst, i, j);
                    }
                }
            }
        }
        System.out.println(answer);
    }
    private static void bfs(int idst, int jdst, int x, int y) {
        if(idst == 0 && jdst == 0) {
            StringBuffer sb = new StringBuffer();
            sb.append(graph[x][y]);
            updateAnswer(sb.toString());
            return;
        }
        if(idst != 0 && jdst == 0) {
            StringBuffer sb = new StringBuffer();
            for(int i = x; i < graph.length; i+= idst) {
                if(i < 0) {
                    updateAnswer(sb.toString());
                    return;
                }
                sb.append(graph[i][y]);
                updateAnswer(sb.toString());
            }
            return;
        }
        if(idst == 0 && jdst != 0) {
            StringBuffer sb = new StringBuffer();
            for(int j = y; j < graph[0].length; j+=jdst) {
                if(j < 0) {
                    updateAnswer(sb.toString());
                    return;
                }
                sb.append(graph[x][j]);
                updateAnswer(sb.toString());
            }
            return;
        }
        StringBuffer sb = new StringBuffer();
        while(x >= 0 && y >= 0 && x < graph.length && y < graph[0].length) {
            sb.append(graph[x][y]);
            updateAnswer(sb.toString());
            x += idst;
            y += jdst;
        }
    }


    private static void updateAnswer(String s) {
        s.replace(" ", "");
        if(s.equals("")) {
            return;
        }
        long num = Long.parseLong(s);
        long compare = (long)Math.sqrt(num);
        if(compare * compare == num) {
            answer = Math.max(answer, num);
        }
    }
}
