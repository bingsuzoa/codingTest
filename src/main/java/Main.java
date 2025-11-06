import java.util.*;
import java.io.*;

class Main {
    static int MOD = 900528;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String goal = br.readLine();

        long answer = 0;

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < input.length(); i++) {
            map.put(input.charAt(i), i + 1);
        }

        int base = input.length();
        for(int i = 0; i < goal.length(); i++) {
            answer = (answer * base + map.get(goal.charAt(i))) % MOD;
        }
        System.out.println(answer % MOD);
    }
    }