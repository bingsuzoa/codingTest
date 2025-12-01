import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Pair> pairs = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            pairs.add(new Pair(x, y));
        }

        Collections.sort(pairs, (o1, o2) -> {
            return (int)(o1.x - o2.x);
        });

        int max = 0;
        for(int i = 0; i < pairs.size(); i++) {
            int cnt = 0;
            int originE = (int)pairs.get(i).y;
            for(int j = i + 1; j < pairs.size(); j++) {
                Pair comp = pairs.get(j);
                int comS = (int)comp.x;
                int comE = (int)comp.y;

                if(comS >= originE) break;
                if(comE < originE) cnt++;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
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