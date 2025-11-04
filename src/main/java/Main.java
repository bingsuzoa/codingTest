import java.util.*;
import java.io.*;

class Main {
    static List<int[]> list;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        pq = new PriorityQueue<>((o1,o2) -> {
            return o1 - o2;
        });

        while(N --> 0) {
            String input = br.readLine();
            String[] temp = input.split(" ");
            int[] array = new int[3];
            array[0] = Integer.parseInt(temp[0].trim());
            array[1] = Integer.parseInt(temp[1].trim());
            array[2] = Integer.parseInt(temp[2].trim());
            list.add(array);
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[2] - o2[2];
            return o1[1] - o2[1];
        });


        int max = 0;
        for(int[] next : list) {
            int start = next[1];
            int end = next[2];

            while(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.add(end);
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
    }
}