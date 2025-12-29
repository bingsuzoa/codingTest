import java.util.*;
import java.io.*;

class Main {
    static long N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        Set<Long> set = new HashSet<>();
        for(int len = 1; len <= 63; len++) {
            for(int a = 1; a <= len; a++) {
                for(int b = 0; b <= len - a; b++) {
                    if(b == 0) {
                        generate(a, b, len, set);
                    }
                    else if(len % (a + b) == 0 || len % (a + b) == a) {
                        generate(a, b, len, set);
                    }
                }
            }
        }
        System.out.println(set.size());
    }

    private static void generate(int a, int b, int totalLen, Set<Long> set) {

        boolean isLeft = true;
        int curLen = 0;
        long num = 0;

        if(b == 0) {
            for(int i = 0; i < totalLen; i++) {
                num <<= 1;
                num |= 1;
            }
            if(num >= N && num <= M) {
                set.add(num);
            }
            return;
        }

        while(curLen < totalLen) {
            int count = isLeft ? a : b;
            for(int i = 0; i < count && curLen < totalLen; i++) {
                num <<= 1;
                if(isLeft) num |= 1;
                curLen++;
            }
            isLeft = !isLeft;
        }

        if(num >= N && num <= M) {
            set.add(num);
        }
    }
}