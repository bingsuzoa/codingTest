import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main { ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer Ainput = new StringTokenizer(br.readLine());
        for(int i =0; i < A.length; i++) {
            A[i] = Integer.parseInt(Ainput.nextToken());
        }
        Arrays.sort(A);

        StringTokenizer Binput = new StringTokenizer(br.readLine());
        for(int i = 0; i < B.length; i++) {
            B[i] = Integer.parseInt(Binput.nextToken());
        }
        Arrays.sort(B);

        int[] temp = new int[N];
        for(int i =0 ; i< temp.length; i++) {
            temp[i] = B[N-1-i];
        }


        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += (A[i] * temp[i]);
        }
        System.out.println(sum);



    }


}
