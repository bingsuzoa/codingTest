import java.util.*;
import java.io.*;

class Main {
    static String st1, st2;
    static int n, m;
    static char[] array1;
    static char[] array2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st1 = br.readLine();
        st2 = br.readLine();

        n = st1.length();
        m = st2.length();

        dp = new int[n+1][m+1];
        array1 = new char[n];
        array2 = new char[m];

        for(int i = 0; i < st1.length(); i++) {
            array1[i] = st1.charAt(i);
        }
        for(int i = 0; i < st2.length(); i++) {
            array2[i] = st2.charAt(i);
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(array1[i-1] == array2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}