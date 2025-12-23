import java.util.*;
import java.io.*;


class Main {
    static int[] graph;
    static int N, M;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for(int i = 0; i < graph.length; i++) {
            graph[i] = Integer.parseInt(st1.nextToken());
            sum += graph[i];
        }
        System.out.println(check());
    }

    private static int check() {
        int start = getMax();
        int end = sum;

        while(start <= end) {
            int mid = (start + end) / 2;

            int result = getCount(mid);
            if(result <= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int getMax() {
        int max = -1;
        for(int i =0 ; i < graph.length; i++) {
           max = Math.max(max, graph[i]);
        }
        return max;
    }

    private static int getCount(int time) {
        int count = 0;

        int cur = 0;
        for(int i = 0; i < graph.length; i++) {
            if(i == graph.length - 1) {
                if(cur + graph[i] > time) {
                    count += 2;
                } else {
                    count += 1;
                }
                break;
            }
            if(cur + graph[i] > time) {
                count++;
                cur = graph[i];
            } else {
                cur += graph[i];
            }
        }
        return count;
    }
}