import java.util.*;
import java.io.*;
import java.util.stream.StreamSupport;

class Main {
    static long l, r;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = Long.parseLong(br.readLine());
        r = Long.parseLong(br.readLine());
        k = Integer.parseInt(br.readLine());

        if(k % 2 != 0) {
            int minM = (k + 1)/2;

            long left = (l + k - 1) / k; // ceil(l / k)
            long right = r / k;          // floor(r / k)

            if(right < minM) {
                System.out.println(0);
                return;
            }
            System.out.println(right - Math.max(minM, left) + 1);
        } else {
            int minM = k + 1;

            long halfK = k / 2;
            long left = (l + halfK - 1) / halfK; // ceil(l / (k/2))
            long right = r / halfK;              // floor(r / (k/2))

            if(right < minM) {
                System.out.println(0);
                return;
            }

//            int bias = (k == 4 && right >= 6 && left <= 6) ? 1 : 0;
            System.out.println(right - Math.max(minM, left) + 1);
        }
    }
}