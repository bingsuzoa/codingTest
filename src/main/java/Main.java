import java.util.*;
import java.io.*;

class Main {
    static int[] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n + 1];

        for (int i = 1; i < board.length; i++) {
            int cur =  board.length -1 - i;
            for(int j = cur - 1; j >= 1; j--) {
                cur *= j;
            }
            board[i] = cur;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        if(k == 1) {
            long goal = Long.parseLong(st.nextToken());
            int[] answer = new int[n];
            searchOne(answer, goal, 0, 1);
            for(int value : answer) {
                System.out.print(value + " ");
            }
        }
    }

    private static void searchOne(int[] answer, long goal, int cur, int bitMask) {
        if(cur == answer.length - 1) {
            for(int i = 1; i <= n; i++) {
                int curBitMask = 1 << i;
                if((curBitMask & bitMask) == 0) {
                    answer[cur] = i;
                    break;
                }
            }
            return;
        }

        for(int i = 1; i <= n; i++) {
            int curBitMask = 1 << i;
            int now = board[i];
            if(goal <= now && (bitMask & curBitMask) == 0) {
                answer[cur] = i;
                searchOne(answer, goal, cur + 1, bitMask | curBitMask);
                return;
            }
            else if(goal > now && (bitMask & curBitMask) == 0) {
                goal -= now;
            }
        }

    }

}