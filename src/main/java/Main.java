import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        Main test = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            while(k --> 0) {
                list[i].add(Integer.parseInt(st.nextToken()) -1);
            }
        }
        System.out.println(test.solution(list, n, m));
    }

    private int solution(List<Integer>[] list, int n, int m) {
        int count = 0;
        int[] cows = new int[n];
        int[] houses = new int[m];
        Arrays.fill(cows, -1);
        Arrays.fill(houses, -1);
        for(int i = 0; i < n; i++) {
            if(dfs(list, i, cows, houses, new boolean[houses.length])) {
                count++;
            }
        }
        return count;
    }

    private boolean dfs(List<Integer>[] list, int cur, int[] cows, int[] houses, boolean[] checked) {
        for(int num : list[cur]) {
            if(checked[num]) continue;
            checked[num] = true;
            if(houses[num] == -1 || dfs(list, houses[num], cows, houses, checked)) {
                cows[cur] = num;
                houses[num] = cur;
                return true;
            }
        }
        return false;
    }


}

