import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static List<int[]>[] list;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        for(int c = 1; c <= C; c++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            list = new ArrayList[M + 1];
            answer = new int[N+1];
            for(int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                for(int j = 0; j < m; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    list[i+1].add(new int[]{x, y});
                }
                Collections.sort(list[i+1], (o1,o2) -> {
                    if(o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                });
            }

            boolean isPossible = true;
            boolean changed = true;
            while(changed) {
                changed = false;

                for(int i = 1; i < list.length; i++) {
                    boolean satisfied = false;
                    int notMatchedFlavor = -1;
                    for(int[] temp : list[i]) {
                        int flavor = temp[0];
                        int malt = temp[1];

                        if(answer[flavor] == malt) {
                            satisfied = true;
                            break;
                        }
                        if(malt == 1) {
                            notMatchedFlavor = flavor;
                        }
                    }

                    if(satisfied) continue;

                    if(notMatchedFlavor != -1 && answer[notMatchedFlavor] == 0) {
                        answer[notMatchedFlavor]  = 1;
                        changed = true;
                        break;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
                if(!isPossible)  break;
            }

            if(isPossible) {
                print(c, true);
            } else {
                print(c, false);
            }
        }
    }
    private static void print(int c, boolean isPossible) {
        if(!isPossible) {
            System.out.println("Case #" + c + ": IMPOSSIBLE");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Case #" + c + ": ");
        for(int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}