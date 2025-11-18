import java.util.*;
import java.io.*;

class Main {
    static String[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new String[N];

        for(int i = 0; i < board.length; i++) {
            String input = br.readLine();
            input = change(input, 'k', 'c');
            input = changeString(input, 'g', 'z');
            board[i] = input;
        }
        Arrays.sort(board);

        for(int i = 0; i < board.length; i++) {
            String input = board[i];
            input = change(input, 'c', 'k');
            input = changeString(input, 'z', 'g');
            System.out.println(input);
        }
    }
    private static String changeString(String input, char from, char to) {
        char[] array = new char[input.length()];
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == 'n') {
                if(i + 1 < input.length()) {
                    char p = input.charAt(i+1);
                    if(p == from) {
                        array[i] = 'n';
                        array[i+1] = to;
                        i = i+1;
                    } else {
                        array[i] = 'n';
                        array[i+1] = p;
                        i = i+1;
                    }
                } else {
                    array[i] = 'n';
                }
            } else {
                array[i] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static String change(String input, char from, char to) {
        char[] array = new char[input.length()];
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == from) {
                array[i] = to;
            } else {
                array[i] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }
}