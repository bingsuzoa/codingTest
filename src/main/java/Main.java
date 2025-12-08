import java.util.*;
import java.io.*;

class Main {
    static int N, A, B;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        N = Integer.parseInt(input.nextToken());
        A = Integer.parseInt(input.nextToken());
        B = Integer.parseInt(input.nextToken());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y, z});
        }

        int max = 0;
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size(); j++) {
                if(i == j) continue;
                int[] array = list.get(i);
                int sx = array[0];
                int sy = array[1];

                int[] pair = list.get(j);
                int ex = pair[0];
                int ey = pair[1];

                if(Math.abs(ex - sx) + 1 <= A && Math.abs(sy - ey)  + 1 <= B) {
                    max = Math.max(Math.abs(array[2] - pair[2]), max);
                }
            }
        }
        System.out.println(max);
    }
}