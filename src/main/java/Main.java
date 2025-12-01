import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Pair> pairs = new ArrayList<>();
        List<Long> nums = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            pairs.add(new Pair(x, y));
            nums.add(x);
            nums.add(y);
        }

        Collections.sort(nums);
        Map<Long, Integer> map = new HashMap<>();
        int idx = 0;
        for(long num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }

        boolean[] start = new boolean[idx];
        boolean[] end = new boolean[idx];
        List<Pair> data = new ArrayList<>();
        for(Pair pair : pairs) {
            int x = map.get(pair.x);
            int y = map.get(pair.y);
            data.add(new Pair(x, y));
            start[x] = true;
            end[y] = true;
        }

        data.sort((o1,o2) -> {
            return (int)((o1.y - o1.x) - (o2.y - o2.x));
        });

        int[] sdp = new int[idx];
        int[] edp = new int[idx];

        if(start[0]) sdp[0] = 1;
        if(end[0]) edp[0] = 1;

        for(int i = 1; i < idx; i++) {
            sdp[i] = sdp[i-1] + (start[i] ? 1 : 0);
            edp[i] = edp[i-1] + (end[i] ? 1 : 0);
        }

        int answer = 0;
        for(int i = data.size() - 1; i >= 0; i--) {
            Pair p = data.get(i);
            int s = (int)p.x;
            int e = (int)p.y;

            int val1;
            if(e > 0) {
                val1 = edp[idx - 1] - edp[e -1];
            } else {
                val1 = edp[idx - 1];
            }
            int val2 = sdp[s];

            answer = Math.max(answer, N - val1 - val2 + 1);
        }
        System.out.println(answer);
    }
}

class Pair {
    long x;
    long y;

    public Pair(long x, long y) {
        this.x = x;
        this.y = y;
    }
}