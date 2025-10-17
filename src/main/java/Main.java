import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String bit = Integer.toBinaryString(N);

        int count = Integer.bitCount(N);

        if(count <= K) {
            System.out.println(0);
            return;
        }

        int index = 0;
        for(int i = 0; i < bit.length(); i++) {
            if(K == 1) {
                index = i;
                break;
            }
            if(bit.charAt(i) == '1') {
                K--;
            }
        }

        String split = bit.substring(index);
        int start = Integer.parseInt(split, 2);


        int cur = start;
        while(true) {
            cur++;
            int c = Integer.bitCount(cur);
            if(c == 1) {
                System.out.println(cur - start);
                break;
            }
        }
    }

}