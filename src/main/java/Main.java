import java.util.*;
import java.io.*;

class Main {
    static long[] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        graph = new long[10];

        long start = 1;
        long end = N;
        int pos = 1;

        while(true) {
            while(true) {
                if(start % 10 != 0 && start <= end) {
                    addNumber(start, pos);
                    start++;
                } else {
                    break;
                }
            }

            while(true) {
                if(end % 10 != 9 && start <= end) {
                    addNumber(end, pos);
                    end--;
                } else {
                    break;
                }
            }

            if(start > end) {
                break;
            }

            start /= 10;
            end /= 10;

            for(int i = 0; i < graph.length; i++) {
                graph[i] += (end - start + 1) * pos;
            }
            pos *= 10;
        }

        StringBuffer sb = new StringBuffer();
        for(long value : graph) {
            sb.append(value + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void addNumber(long num, int pos) {
        while(num > 0) {
            graph[(int)num % 10] += pos;
            num /= 10;
        }
    }
}