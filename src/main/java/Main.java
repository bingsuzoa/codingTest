import java.util.*;
import java.io.*;

class Main {
    static List<String>[] list;
    static String input;
    static Queue<String> queue;

    static String answer;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        input = st.nextToken();

        list = new ArrayList[81];
        for(int i =0 ; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            list[s.length()].add(s);
        }

        queue = new LinkedList<>();
        queue.add(input);

        while(!queue.isEmpty()) {
            String cur = queue.poll();

            for(String next : list[cur.length() + 1]) {
                int left = 0;
                int right = 0;
                int oppt = 0;

                while(left < cur.length() && right < next.length()) {
                    if(cur.charAt(left) != next.charAt(right)) {
                        if(oppt < 1) {
                            oppt++;
                            right++;
                        } else {
                            break;
                        }
                    } else {
                        left ++;
                        right ++;
                    }
                }
                if(left == cur.length() && oppt <= 1) {
                    if(max < next.length()) {
                        max = next.length();
                        answer = next;
                    }
                    queue.add(next);
                }
            }
        }

        if(max == 0) {
            System.out.println(input);
        } else {
            System.out.println(answer);
        }
    }
}