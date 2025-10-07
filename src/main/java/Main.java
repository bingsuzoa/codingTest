import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] array = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            int result = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (check(j, i, array)) {
                    result++;
                }
            }
            for (int j = i + 1; j < array.length; j++) {
                if (check(i, j, array)) {
                    result++;
                }
            }
            answer = Math.max(answer, result);
        }
        System.out.println(answer);
    }

    private static boolean check(int left, int right, long[] array) {
        boolean isResult = true;
        double incline = (double)(array[right] - array[left]) / (right - left);

        for (int i = left + 1; i < right; i++) {
            double y = (incline * (i - left)) + array[left];

            if (array[i] >= y) {
                isResult = false;
                break;
            }
        }
        return isResult;
    }


}
