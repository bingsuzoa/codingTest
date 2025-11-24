import java.util.*;
import java.io.*;

class Main {
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        while(M --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new int[]{e, c});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            return o1[1] - o2[1];
        });

        int[] costs = new int[N+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        pq.add(new int[]{start, 0});
        costs[0] = 0;

        while(!pq.isEmpty()) {
            int[] from = pq.poll();
            int cost = from[1];

            if(costs[from[0]] < cost) {
                continue;
            }

            for(int[] to : list[from[0]]) {
                int next = to[0];
                if(costs[next] > cost + to[1]) {
                    costs[next] = cost + to[1];
                    pq.add(new int[]{next, costs[next]});
                }
            }
        }
        System.out.println(costs[end]);
    }
}