import java.util.*;
import java.io.*;

class Main {
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N];
        for(int i = 0; i < board.length; i++) {
            board[i] = i+1;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        if(k == 1) {
            long goal = Long.parseLong(st.nextToken());
            int[] result = whenOne(goal);
            StringBuilder sb = new StringBuilder();
            for(int value : result) {
                sb.append(value).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            int[] array = new int[N];
            for(int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(whenTwo(array));
        }
    }

    private static long whenTwo(int[] array) {
        boolean[] visited = new boolean[board.length];
        return findTwo(0, 0, visited, array);
    }
    private static long findTwo(int cur, long sum, boolean[] visited, int[] array) {
        if(cur == array.length) {
            return sum + 1;
        }

        for(int i =0 ; i < visited.length; i++) {
            if(visited[i]) continue;
            long num = board[i];
            long now = getRemain(cur);
            if(array[cur] == num) {
                visited[i] = true;
                return findTwo(cur + 1, sum, visited, array);
            } else {
                sum += now;
            }
        }
        return 0;
    }

    private static int[] whenOne(long goal) {
        int[] result = new int[board.length];
        find(goal, 0, result, new boolean[board.length]);
        return result;
    }

    private static void find(long goal, int cur, int[] array, boolean[] visited) {
        if(cur == array.length) {
            return;
        }

        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) continue;
            int num = board[i];
            long opt = getRemain(cur);
            if(opt == 0) {
                array[cur] = num;
                return;
            }
            if(goal <= opt) {
                array[cur] = num;
                visited[i] = true;
                find(goal, cur + 1, array, visited);
                return;
            } else {
                goal -= opt;
            }
        }
    }

    private static long getRemain(int cur) {
        int n = board.length -1 - cur;
        if(n == 0) {
            return 0;
        }
        long result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}