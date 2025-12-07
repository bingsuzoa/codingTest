import java.util.*;
import java.io.*;

class Main {
    static Map<Long, Integer> map = new HashMap<>();
    static List<int[]> list = new ArrayList<>();
    static List<Integer>[] xList;
    static List<Integer>[] yList;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N < 4) {
            System.out.println(0);
            return;
        }

        int idx = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            if(!map.containsKey(x)) {
                map.put(x, idx++);
            }
            if(!map.containsKey(y)) {
                map.put(y, idx++);
            }
            list.add(new int[]{map.get(x), map.get(y)});
        }

        xList = new ArrayList[idx];
        yList = new ArrayList[idx];

        for(int i = 0; i < xList.length; i++) {
            xList[i] = new ArrayList<>();
            yList[i] = new ArrayList<>();
        }

        for(int[] temp : list) {
            xList[temp[0]].add(temp[1]);
            yList[temp[1]].add(temp[0]);
        }

        for(int i = 0; i < xList.length; i++) {
            Collections.sort(xList[i]);
            Collections.sort(yList[i]);
        }

        Set<String> uniqueSet = new HashSet<>();
        for(int i = 0; i < xList.length; i++) {
            List<Integer> temp = xList[i];
            if(temp.size() < 2) continue;
            for(int j = 0; j < temp.size(); j++) {
                for(int k = j + 1; k < temp.size(); k++) {
                    int left = temp.get(j);
                    int right = temp.get(k);
                    String value = String.valueOf(left) + " " + String.valueOf(right);
                    if(!uniqueSet.contains(value)) {
                        uniqueSet.add(value);
                        check(yList[left], yList[right]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
    private static void check(List<Integer> list1, List<Integer> list2) {
        int count = 0;
        for(int value : list1) {
            if(list2.contains(value)) {
                count++;
            }
        }
        if(count == 0 || count == 1) return;

        long sum = 0;
        for(int i = count  - 1; i >= 1; i--) {
            sum += i;
        }
        answer += sum;
    }
}