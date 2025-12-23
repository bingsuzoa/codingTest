import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static List<int[]> list;
    static List<int[]> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int L = Integer.parseInt(br.readLine());
            int[] temp = new int[L];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < temp.length; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            list.add(temp);
        }
        for (int i = 0; i < list.size(); i++) {
            decide(list.get(i));
        }

//        Collections.sort(result, (o1, o2) -> {
//            if (o1[0] == o2[0]) {
//                return o1[1] - o2[1];
//            }
//            return o1[0] - o2[0];
//        });

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int[] array : result) {
            sum += array[2];
        }
        sb.append(sum).append("\n");
        for (int[] array : result) {
            sb.append(array[0] + " " + array[1]).append("\n");
        }
        System.out.println(sb);
    }
    private static void decide(int[] graph) {
        int sum = graph[0];

        int maxLeft =0;
        int maxRight = 0;
        int maxSum = graph[0];

        int left = 0;
        int right = 0;
        for(int i = 1; i < graph.length; i++) {
            if(sum + graph[i] <= graph[i]) {
                left = i;
                right = i;
                sum = graph[i];
            } else {
                right = i;
                sum += graph[i];
            }
            if(sum > maxSum) {
                maxLeft = left;
                maxRight = right;
                maxSum = sum;
            }
            else if(sum == maxSum) {
                if(maxRight - maxLeft > right - left) {
                    maxRight = right;
                    maxLeft = left;
                }
            }
        }
        result.add(new int[]{maxLeft + 1, maxRight + 1, maxSum});
    }
}