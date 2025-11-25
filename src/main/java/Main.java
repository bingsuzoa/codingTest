import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] graph = new boolean[end + 1];
        Arrays.fill(graph, true);
        graph[0] = false;
        graph[1] = false;


        for(int i = 2; i * i < graph.length; i++) {
            if(graph[i]) {
                for(int j = i + i; j < graph.length; j+= i) {
                    graph[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= end; i++) {
            if(graph[i] && isTrue(i)) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb + "-1");
    }

    private static boolean isTrue(int num) {
        String n = String.valueOf(num);
        int[] temp = new int[n.length()];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = n.charAt(i) - '0';
        }

        for(int i = 0; i < temp.length / 2; i++) {
            if(temp[i] != temp[temp.length - 1 -i]) {
                return false;
            }
        }
        return true;
    }

}