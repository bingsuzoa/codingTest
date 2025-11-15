import java.util.*;
import java.io.*;

class Main {
    static int N;
    static char[][] graph;
    static List<int[]> list;
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        list = new ArrayList<>();

        for(int i = 0; i < graph.length; i++) {
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                graph[i][j] = input.charAt(j);
            }
        }
        int num = 1;
        for(char c = 'A'; c <= 'I'; c++) {
            map.put(c, num * -1);
            num++;
        }

        dfs(0, new boolean[N], new int[N]);

        int max = -100000;
        int min = 100000;

        for(int i = 0; i < list.size(); i++) {
            int[] graph1 = list.get(i);
            for(int j = 0; j < list.size(); j++) {
                int[] graph2 = list.get(j);

                int result = getMultiply(graph1, graph2);
                int count = getCircleCount(graph1, graph2);
                if(count % 2 == 0) {
                    result *= -1;
                }
                min = Math.min(min, result);
                max = Math.max(max, result);
            }
        }
        System.out.print(min + "\n" + max);
    }
    private static int getMultiply(int[] graph1, int[] graph2) {
        int sum = 1;
        for(int i = 0; i < graph1.length; i++) {
            int x = graph1[i];
            int y = graph2[i];
            char c = graph[x][y];
            if(map.containsKey(c)) {
                sum *= map.get(c);
            } else {
                sum *= (c -'0');
            }
        }
        return sum;
    }

    private static int getCircleCount(int[] graph1, int[] graph2) {
        int count = 0;
        boolean[] visited = new boolean[graph1.length];
        for(int i = 0; i < graph1.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(findCircle(visited, graph1, graph2, i, graph1[i])) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean findCircle(boolean[] visited, int[] graph1, int[] graph2, int cur, int goal) {
        if(graph2[cur] == goal) {
            return true;
        }

        int next = graph2[cur];
        for(int i = 0; i < graph1.length; i++) {
            if(graph1[i] == next) {
                visited[i] = true;
                return findCircle(visited, graph1, graph2, i, goal);
            }
        }
        return false;
    }

    private static void dfs(int cur, boolean[] visited, int[] array) {
        if(cur == array.length) {
            list.add(Arrays.copyOf(array, array.length));
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                array[cur] = i;
                dfs(cur + 1, visited, array);
                visited[i] = false;
            }
        }
    }
}