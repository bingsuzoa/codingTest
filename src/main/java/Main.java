import java.util.*;
import java.io.*;

class Main {
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        while(n --> 0) {
            String input = br.readLine().toLowerCase();
            char[] charArray = input.toCharArray();

            if(input.length() <= 2) {
                map.put(input, map.getOrDefault(input, 0) + 1);
                continue;
            }

            String temp = input.substring(1, input.length() -1);
            char[] tempArray = temp.toCharArray();
            Arrays.sort(tempArray);
            int idx = 1;
            for(char c : tempArray) {
                charArray[idx++] = c;
            }

            String newInput = new String(charArray);
            map.put(newInput, map.getOrDefault(newInput, 0) + 1);
        }


        int m = Integer.parseInt(br.readLine());
        while(m --> 0) {
            int count = 1;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while(st.hasMoreTokens()) {
                String input = st.nextToken().toLowerCase();
                count *= getResult(input);
            }
            System.out.println(count);
        }
    }
    private static int getResult(String word) {
        if(word.length() <= 2) {
            if(!map.containsKey(word)) {
                return 0;
            }
            return map.get(word);
        }

        char[] wordArray = word.toCharArray();
        String temp= word.substring(1, word.length() -1);
        char[] tempArray = temp.toCharArray();
        Arrays.sort(tempArray);
        int idx = 1;
        for(char c : tempArray) {
            wordArray[idx++] = c;
        }
        String result = new String(wordArray);
        if(!map.containsKey(result)) {
            return 0;
        }
        return map.get(result);
    }
}