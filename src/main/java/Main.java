import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        int size = 0;
        while(N --> 0) {
            int n = Integer.parseInt(br.readLine());
            int idx = check(list, n);
            list.add(idx, n);

            size++;
            bw.write(list.get((size - 1)/2) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int check(List<Integer> list, int n) {
        int start = 0;
        int end = list.size();

        if(list.size() == 0) {
            return 0;
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            if(mid == list.size()) {
                return mid;
            }
            if(list.get(mid) <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}