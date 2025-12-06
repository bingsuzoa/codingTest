import java.util.*;
import java.io.*;

class Main {
    static List<int[]> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }
        list.add(new int[]{list.get(0)[0], list.get(0)[1]});

        double answer;
        long sum = 0;
        int left = 0;
        int right = 1;
        while(right < list.size()) {
            int[] first = list.get(left);
            int[] second = list.get(right);

            int lx = first[0];
            int ly = first[1];
            int rx = second[0];
            int ry = second[1];
            sum += ((long)lx * ry) - ((long)rx * ly);

            left++;
            right++;
        }
        answer = Math.abs(sum) * 0.5;
        System.out.printf("%.1f", answer);
    }
}