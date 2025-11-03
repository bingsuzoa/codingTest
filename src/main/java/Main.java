import java.util.*;
import java.io.*;

class Main {
    static List<Node> results;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        results = new ArrayList<>();
        results.add(new Node(0, ""));
        while(N > 0) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) continue;
            String[] array = input.split(" ");
            if(array[0].contains("type")) {
                String value = array[1].trim();
                int second = Integer.parseInt(array[2].trim());

                String lastValue = results.get(results.size() -1).value;
                results.add(new Node(second, lastValue + value));

            }
            else if(array[0].contains("undo")) {
                int to = Integer.parseInt(array[1].trim());
                int from = Integer.parseInt(array[2].trim());
                int idx = results.size() - 1;
                int goal = from - to - 1;

                boolean isFlag = false;
                while(idx >= 0) {
                    Node cur = results.get(idx);
                    int sec = cur.sec;
                    String value = cur.value;
                    if(goal < sec) {
                        idx--;
                    } else {
                        results.add(new Node(from, value));
                        isFlag = true;
                        break;
                    }
                }
                if(!isFlag) {
                    results.add(new Node(from, ""));
                }
            }
            N--;
        }
        System.out.println(results.get(results.size() - 1).value);
    }
}

class Node {
    int sec;
    String value;

    public Node(int sec, String value) {
        this.sec = sec;
        this.value = value;
    }
}