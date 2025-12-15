import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        boolean[] juseoks = new boolean[N+1];

        int pow = 0;
        while(true) {
            if((int)Math.pow(2, pow) > N + N) {
                break;
            }
            pow++;
        }

        for(int i = 1; i < pow; i++) {
            list.add((int)Math.pow(2, i));
        }

        for(int i = N ; i >= 1; i--) {
            for(int j = list.size() -1; j>= 0; j--) {
                int pair = Math.abs(i - list.get(j));
                if(pair == 0 || juseoks.length <= pair || juseoks[pair]) continue;
                juseoks[pair] = true;
                answer.add(pair);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = answer.size() - 1; i >= 0; i-- ){
            sb.append(answer.get(i)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}