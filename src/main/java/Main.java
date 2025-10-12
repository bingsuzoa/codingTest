import java.io.*;
import java.util.*;

class Main {
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] inputs = new String[N-1];
        long lcm = 1;
        list = new ArrayList[N];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < inputs.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, p, q});
            list[b].add(new int[]{a, q, p});
            lcm *= lcm(p, q);
        }

        long[] ratio = new long[N];
        ratio[0] = lcm;
        boolean[] visited = new boolean[N];
        visited[0] = true;
        dfs(0, ratio, visited);

        long mgcd = ratio[0];
        for(int i = 1; i < ratio.length; i++) {
            mgcd = gcd(mgcd, ratio[i]);
        }

        StringBuffer sb = new StringBuffer();
        for(long r : ratio) {
            sb.append((r / mgcd) + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void dfs(int node, long[] ratio, boolean[] visited) {
        for(int[] to : list[node]) {
            int next = to[0];
            int p = to[1];
            int q = to[2];
            if(!visited[next]) {
                ratio[next] = ratio[node] * q / p;
                visited[next] = true;
                dfs(next, ratio, visited);
            }
        }
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}