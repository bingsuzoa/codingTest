import java.util.*;
import java.io.*;

class Main {
    static List<String> words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        words = new ArrayList<>();
        while(true) {
            String word = br.readLine();
            if(word.equals("-")) {
                break;
            }
            words.add(word);
        }

        while(true) {
            String input = br.readLine();
            if(input.equals("#")) {
                break;
            }
            List<String> list = getList(input);
            System.out.println(check(list, input));
        }

    }
    private static String check(List<String> list, String input) {
        int[] result = new int[input.length()];
        char[] inputChar = input.toCharArray();
        Arrays.sort(inputChar);

        for(String word : list) {
            boolean[] visited = new boolean[input.length()];
            for(char c : word.toCharArray()) {
                for(int i =0; i< inputChar.length; i++) {
                    if(!visited[i] && inputChar[i] == c) {
                        visited[i] = true;
                        result[i]++;
                    }
                }
            }
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int r : result) {
            max = Math.max(r, max);
            min = Math.min(r, min);
        }

        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();

        Set<Character> sbSet = new HashSet<>();
        Set<Character> sb1Set = new HashSet<>();
        for(int i =0 ; i < result.length; i++) {
            if(!sbSet.contains(inputChar[i]) && result[i] == max) {
                sbSet.add(inputChar[i]);
                sb.append(inputChar[i]);
            }
            if(!sb1Set.contains(inputChar[i]) && result[i] == min) {
                sb1Set.add(inputChar[i]);
                sb1.append(inputChar[i]);
            }
        }
        sb.append(" ").append(max);
        sb1.append(" ").append(min);

        sb1.append(" ").append(sb);
        return sb1.toString();
    }

    private static List<String> getList(String input) {
        List<String> list = new ArrayList<>();

        for(String word : words) {
            if(isChecked(input, word)) {
                list.add(word);
            }
        }
        return list;
    }

    private static boolean isChecked(String input, String word) {
        char[] inputChars = input.toCharArray();
        char[] wordChars = word.toCharArray();
        Arrays.sort(inputChars);
        Arrays.sort(wordChars);

        boolean[] checked = new boolean[inputChars.length];

        for(char w : wordChars) {
            boolean pass = false;
            for(int i = 0; i < inputChars.length; i++) {
                if(!checked[i] && inputChars[i] == w) {
                    checked[i] = true;
                    pass = true;
                    break;
                }
            }
            if(!pass) {
                return false;
            }
        }
        return true;
    }
}
