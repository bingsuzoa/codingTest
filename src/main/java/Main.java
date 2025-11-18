import java.util.*;
import java.io.*;

class Main {
    static String word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String word = br.readLine();
        String text = br.readLine();

        int[] wArr = new int[52];
        for(int i = 0; i < word.length(); i++) {
            putChar(word.charAt(i), wArr, 1);
        }
        int[] tArr = new int[52];

        int size = 0;
        int cnt = 0;
        int start = 0;
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            putChar(c, tArr, 1);
            size++;

            if(size == word.length()) {
                if(Arrays.equals(wArr, tArr)) {
                    cnt++;
                }
                putChar(text.charAt(start), tArr, -1);
                size--;
                start++;
            }
        }
        System.out.println(cnt);
    }

    private static void putChar(char c, int[] arr, int num) {
        if(c >= 'a' && c <= 'z') {
            arr[c - 'a'] += num;
        } else {
            arr[c - 'A' + 26] += num;
        }
    }
}