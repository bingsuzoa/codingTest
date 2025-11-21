import java.util.*;
import java.io.*;


class Main {
    static int D, N;
    static long[] dArr;
    static long[] nArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st1.nextToken());
        N = Integer.parseInt(st1.nextToken());

        StringTokenizer d = new StringTokenizer(br.readLine());
        StringTokenizer n = new StringTokenizer(br.readLine());

        dArr = new long[D];
        nArr = new long[N];

        for(int i = 0; i < dArr.length; i++) {
            dArr[i] = Long.parseLong(d.nextToken());
        }
        for(int i =0 ; i < nArr.length; i++) {
            nArr[i] = Long.parseLong(n.nextToken());
        }

        long min = Long.MAX_VALUE;
        for(int i = 0; i < dArr.length; i++) {
            min = Math.min(min, dArr[i]);
            if(min < dArr[i]) {
                dArr[i] = min;
            }
        }

        int idx = 0;
        int answer = 0;
        long standard = nArr[0];

        boolean flag = false;
        for(int i = dArr.length-1; i >= 0; i--) {
            if(idx == 0) {
                if(nArr[idx] <= dArr[i]) {
                    idx++;
                }
            } else {
                if (nArr[idx] <= standard) {
                    idx++;
                } else {
                    if(nArr[idx] <= dArr[i]) {
                        standard = Math.max(standard, nArr[idx]);
                        idx++;
                    }
                }
            }
            if(idx == nArr.length) {
                answer = i+1;
                flag = true;
                break;
            }
        }
        if(!flag) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}