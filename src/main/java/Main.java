import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main {
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();

        graph = new int[input.length()];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = input.charAt(i) -'0';
        }

        if(onlyNine()) {
            System.out.println(printOnlyNine());
            return;
        }

        int mid = graph.length / 2;
        if(graph.length % 2 != 0) {
            calculateWhenOdd(mid, mid);
        } else {
            calculateWhenEven(mid - 1, mid);
        }
    }
    private static void calculateWhenEven(int idx, int other) {
        if(idx < 0) {
            return;
        }

        int[] temp = new int[graph.length];
        for(int i = 0; i < idx; i++) {
            temp[i] = graph[i];
            temp[graph.length - 1 - i] = graph[i];
        }
        int mid = graph[idx];
        for(int i = mid; i < 10; i++) {
            temp[idx] = i;
            temp[other] = i;
            for(int n = idx + 1; n < other; n++) {
                temp[n] = 0;
            }
            if(compare(temp)) {
                System.out.println(getString(temp));
                return;
            }
        }
        calculateWhenEven(idx -1, other + 1);
    }

    private static void calculateWhenOdd(int idx, int other) {
        if(idx < 0) {
            return;
        }

        if(idx == other) {
            int[] temp= new int[graph.length];
            for(int i = 0; i < graph.length/2; i++) {
                temp[i] = graph[i];
                temp[graph.length -1 -i] = graph[i];
            }
            int mid = graph[idx];
            for(int i = mid; i < 10; i++) {
                temp[idx] = i;
                if(compare(temp)) {
                    System.out.println(getString(temp));
                    return;
                }
            }
            calculateWhenOdd(idx -1, other + 1);
        } else {
            int[] temp = new int[graph.length];
            for(int i = 0; i < idx; i++) {
                temp[i] = graph[i];
                temp[graph.length - 1 - i] = graph[i];
            }
            int mid = graph[idx];
            for(int i = mid; i < 10; i++) {
                temp[idx] = i;
                temp[other] = i;
                for(int n = idx + 1; n < other; n++) {
                    temp[n] = 0;
                }
                if(compare(temp)) {
                    System.out.println(getString(temp));
                    return;
                }
            }
            calculateWhenOdd(idx -1, other + 1);
        }
    }
    private static boolean compare(int[] temp) {
        for(int i =0 ; i < temp.length; i++) {
            if(graph[i] < temp[i]) {
                return true;
            }
            if(graph[i] > temp[i]) {
                return false;
            }
        }
        return false;
    }

    private static String getString(int[] temp) {
        StringBuilder graphInput = new StringBuilder();
        for(int v : temp) {
            graphInput.append(v);
        }
        return graphInput.toString();
    }

    private static boolean onlyNine() {
        for(int i = 0; i < graph.length; i++) {
            if(graph[i] != 9) {
                return false;
            }
        }
        return true;
    }

    private static String printOnlyNine() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= graph.length; i++) {
            if(i == 0 || i == graph.length) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}