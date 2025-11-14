import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int minCount = Integer.MAX_VALUE;
        for(int i = N; i >= 1; i--) {
            minCount = Math.min(minCount, countChange(input, i));
        }
        System.out.println(minCount);
    }

    private static int countChange(String input, int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            int A = 0;
            int G = 0;
            int C = 0;
            int T = 0;
            int min = Integer.MAX_VALUE;
            for(int j = i; j < input.length(); j += n) {
                char c = input.charAt(j);
                if(c != 'A') {
                    A++;
                }
                if(c != 'G') {
                    G++;
                }
                if(c != 'C') {
                    C++;
                }
                if(c != 'T') {
                    T++;
                }
            }
            min = Math.min(min, Math.min(A, G));
            min = Math.min(min, Math.min(C, T));
            count += min;
        }
        return count;
    }
}