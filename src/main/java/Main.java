import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Info[] infos = new Info[N];
        for(int i =0 ; i < infos.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int input_dur = Integer.parseInt(st.nextToken());
            int input_end =  Integer.parseInt(st.nextToken());
            infos[i] = new Info(i, input_dur, input_end);
        }
        Arrays.sort(infos);

        int now = infos[0].end;
        for(Info info : infos) {
            int dur = info.dur;
            int end = info.end;
            if(end < now) {
                now = (end - dur);
            } else {
                now -= dur;
            }
        }
        if(now < 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(now);
    }
}

class Info implements Comparable<Info> {
    int order;
    int dur;
    int end;

    Info(int order, int dur, int end) {
        this.order = order;
        this.dur = dur;
        this.end = end;
    }

    @Override
    public int compareTo(Info o) {
        return o.end - this.end;
    }
}