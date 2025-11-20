import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Integer.parseInt(st.nextToken());
        long end = Integer.parseInt(st.nextToken());

        long goal = end - start;

        if(goal == 0) {
            System.out.println(0);
            return;
        }

        long k = (long)Math.sqrt(goal);

        if(k * k == goal) {
            System.out.println(2 * k - 1);
        }
        else if(k * k < goal && k * (k + 1) >= goal) {
            System.out.println(2* k);
        } else {
            System.out.println(2 * k + 1);
        }

    }
}
