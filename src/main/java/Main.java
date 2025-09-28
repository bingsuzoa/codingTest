import java.util.*;

class Main {

    public static void main(String[] args) {
        Main test = new Main();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] result = test.solution(N);

        StringBuffer sb = new StringBuffer();
        for (int value : result) {
            sb.append(value + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private int[] solution(int N) {
        int start = 1;
        int end = N;
        int digit = 1;

        int[] cnt = new int[10];

        while (start <= end) {
            while (start % 10 != 0 && start <= end) {
                addNumber(start, digit, cnt);
                start++;
            }

            while (end % 10 != 9 && start <= end) {
                addNumber(end, digit, cnt);
                end--;
            }

            if (start > end) break;

            start /= 10;
            end /= 10;

            for (int i = 0; i < 10; i++) {
                cnt[i] += (end - start + 1) * digit;
            }

            digit *= 10;
        }
        return cnt;
    }

    private void addNumber(int start, int digit, int[] cnt) {
        while (start > 0) {
            cnt[start % 10] += digit;
            start /= 10;
        }
    }
}

