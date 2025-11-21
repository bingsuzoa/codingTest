import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T --> 0)  {
            String input = br.readLine();

            if(input.length() == 1) {
                System.out.println("YES");
                continue;
            }

            if(isPass(input, 0, input.length() - 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPass(String input, int left, int right) {
        int mid = (left + right) / 2;
        if(right - left >= 3) {
            if(!isPass(input, left, mid -1)) {
                return false;
            }
            if(!isPass(input, mid + 1, right)) {
                return false;
            }
        }

        for(int i = left, j = right; i < mid; i++, j--) {
            if(input.charAt(i) == input.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}   