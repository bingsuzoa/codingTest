import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        while(N --> 0) {
            int n = Integer.parseInt(br.readLine());

            if(left.isEmpty() || n <= left.peek()) {
                left.add(n);
            } else {
                right.add(n);
            }

            if(right.size() - left.size() == 1) {
                left.offer(right.poll());
            }
            else if(left.size() - right.size() >= 2) {
                right.offer(left.poll());
            }

            bw.write(left.peek() + "\n");
        }

        bw.flush();
        bw.close();

    }
}