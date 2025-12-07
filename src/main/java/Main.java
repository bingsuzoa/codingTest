import java.util.*;
import java.io.*;

class Main {
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i =0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        Collections.sort(list, (o1,o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int[] first = list.get(0);
        int start = first[0];
        int end = first[1];
        long result = (end - start);
        for(int i = 1; i < list.size(); i++) {
            int[] temp = list.get(i);
            if(end < temp[0]) {
                start = temp[0];
                end = temp[1];
                result += (end - start);
            }
            else if(start <= temp[0] && end < temp[1]) {
                result += (temp[1] - end);
                end = temp[1];
            }
        }
        System.out.println(result);
    }
}