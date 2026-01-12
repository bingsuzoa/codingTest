import java.util.*;
import java.io.*;

class Main {
    static char[] graph;
    static Stack<long[]> stack;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new char[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < graph.length; i++) {
            graph[i] = st.nextToken().charAt(0);
        }

        if(!validate()) {
            System.out.println(-1);
            return;
        }
        stack = new Stack<>();

        for(int i = 0; i < graph.length; i++) {
            char c = graph[i];
            if(c == ')') {
                calculate();
            }
            if(isDigit(c)) {
                stack.push(new long[]{c - '0', 1});
            }
        }

        if(stack.size() != 1) {
            System.out.println(-1);
            return;
        }
        long[] result = stack.pop();
        System.out.println(result[0] + " " + result[1]);
    }
    private static void calculate() {
        if(stack.size() >= 3) {
            long[] n1 = stack.pop();
            long e = n1[0];
            long f = n1[1];
            long[] n2 = stack.pop();
            long c = n2[0];
            long d = n2[1];
            long[] n3 = stack.pop();
            long a = n3[0];
            long b = n3[1];

            long upper = (b * c * f) + (a * d * e);
            long bottom = b * d * e;

            long gcd = gcd(upper, bottom);
            stack.push(new long[]{upper / gcd, bottom / gcd});
        }
    }
    private static long gcd(long a, long b) {
        while(b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private static boolean isDigit(char c) {
        if(c - '0' >= 0 && c - '0' <= 9) {
            return true;
        }
        return false;
    }

    private static boolean validate() {
        Stack stack = new Stack<>();
        for(char c : graph) {
            if(c == '(') {
                stack.add('(');
            }
            else if(c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}