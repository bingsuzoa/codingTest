import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            String input = br.readLine().toUpperCase().replace(" ", "");

            char[] graph = new char[input.length()];
            Arrays.fill(graph, '0');
            graph[0] = input.charAt(0);


            int cur = 0;
            for(int i = 1; i < input.length(); i++) {
                char c = input.charAt(i);
                cur += N;
                if(cur >= graph.length) {
                    cur = getBlankIdx(graph);
                    if(cur == -1) {
                        break;
                    }
                }
                graph[cur] = c;
            }
            print(graph);
        }
    }
    private static void print(char[] graph) {
        StringBuilder sb = new StringBuilder();
        for(char c : graph) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    private static int getBlankIdx(char[] graph) {
        for(int i = 0; i < graph.length; i++) {
            if(graph[i] == '0') {
                return i;
            }
        }
        return -1;
    }
}