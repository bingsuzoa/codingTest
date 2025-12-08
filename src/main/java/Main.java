import java.util.*;
import java.io.*;

class Main {
    static String input, goal;
    static Map<Character, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().toLowerCase();
        goal = br.readLine().toLowerCase();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        for(List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int startIdx = 0;
        int count = 0;
        while(startIdx < goal.length()) {
            char sc = goal.charAt(startIdx);
            List<Integer> list = map.get(sc);

            int maxLength = 0;
            for(int idx : list) {
                StringBuilder sb = new StringBuilder();
                StringBuilder st = new StringBuilder();
                int up = 0;
                for(int i = idx; i < input.length(); i++) {
                    sb.append(input.charAt(i));
                    if(startIdx + up < goal.length()) {
                        st.append(goal.charAt(startIdx + up));
                    } else {
                        st.append(goal.charAt(startIdx));
                    }
                    if(sb.toString().equals(st.toString())) {
                        maxLength = Math.max(maxLength, sb.toString().length());
                        up++;
                    } else {
                        break;
                    }
                }
            }
            count++;
            startIdx = startIdx + maxLength;
        }
        System.out.println(count);
    }
}