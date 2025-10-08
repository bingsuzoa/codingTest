import java.util.*;
import java.io.*;

class Main {
    static List<Integer>[] list;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < graph.length; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] primes = new boolean[2001];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for(int i = 2; i <= (int)Math.sqrt(2000); i++) {
            if(primes[i]) {
                for(int j = i + i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }

        list = new ArrayList[N];
        for(int i = 0; i < graph.length; i++) {
            list[i] = new ArrayList<>();
            for(int j = 0; j < graph.length; j++) {
                if(i == j) continue;
                if(primes[graph[i] + graph[j]]) {
                    list[i].add(j);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(int first : list[0]) {
            int[] left = new int[N];
            int[] right = new int[N];
            Arrays.fill(left, -1);
            Arrays.fill(right, -1);
            left[0] = first;
            right[first] = 0;
            int result = 1;
            for(int idx = 1; idx < graph.length; idx++) {
                if(dfs(idx, new boolean[N], left, right)) {
                    result++;
                }
            }
            if(result == list.length) {
                answer.add(graph[first]);
            }
        }
        if(answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            StringBuffer sb = new StringBuffer();
            for(int value : answer) {
                sb.append(value + " ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static boolean dfs(int cnt, boolean[] checked, int[] left, int[] right) {
        if(cnt == 0 || checked[cnt]) {
            return false;
        }
        for(int next : list[cnt]) {
            checked[cnt] = true;
            if(right[next] == -1 || dfs(right[next], checked, left, right)) {
                left[cnt] = next;
                right[next] = cnt;
                return true;
            }
        }
        return false;
    }
}