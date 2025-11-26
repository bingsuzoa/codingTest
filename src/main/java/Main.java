import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int[] pair = new int[4];
        int[] array = new int[4];

        StringBuilder sb = new StringBuilder();
        while(K --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < 4; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 4; i++) {
                pair[i] = Integer.parseInt(st.nextToken());
            }

            boolean flag = false;
            outer:
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(array[i] == pair[j]) {
                        int[] a1 = new int[3];
                        int[] atemp= getOrder(i);
                        for (int k = 0; k < a1.length; k++) {
                            a1[k] = array[atemp[k]];
                        }

                        int[] b1 = new int[3];
                        int[] btemp = getOrder(j);
                        for (int k = 0; k < b1.length; k++) {
                            b1[k] = pair[btemp[k]];
                        }

                        for(int k = 0; k < 3; k++) {
                            int first = b1[k];
                            int second = b1[(k + 1) % 3];
                            int third = b1[(k + 2) % 3];

                            if (a1[0] == first && a1[1] == second && a1[2] == third) {
                                flag = true;
                                break outer;
                            }
                        }
                    }
                }
            }
            if(!flag) {
                sb.append(0).append("\n");
            } else {
                sb.append(1).append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static int[] getOrder(int idx) {
        int[] zero = new int[]{1,2,3};
        int[] one = new int[]{0,3,2};
        int[] two = new int[]{0,1,3};
        int[] three = new int[]{0,2,1};
        if(idx == 0) {
            return zero;
        }
        if(idx == 1) {
            return one;
        }
        if(idx == 2) {
            return two;
        }
        return three;
    }
}