import java.util.*;
import java.io.*;


class Main {
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 0;
        while(A < B) {
            count += isCheck(A, B);
            A++;
        }
        System.out.println(count);
    }

    private static int isCheck(int x, int B) {
        String s = String.valueOf(x);
        int len = s.length();

        set.clear();

        for(int i = len -1; i > 0; i--) {
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < len; j++) {
                sb.append(s.charAt(j));
            }
            for(int j = 0; j < i; j++) {
                sb.append(s.charAt(j));
            }
            int y = Integer.parseInt(sb.toString());
            if(x < y && y <= B) {
                set.add(y);
            }
        }
        return set.size();
    }
}