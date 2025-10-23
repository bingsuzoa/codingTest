import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] graph = new double[N];

        for(int i = 0; i < graph.length; i++) {
            graph[i] = Double.parseDouble(br.readLine());
        }

        int min = 1000;
        for(int n = 1; n <= 1000; n++) {
            boolean isPossible = true;
            for(double value : graph) {
                double left = (value) * n;
                double right = (value + 0.001) * n;

                int leftInt = (int)Math.ceil(left - 1e-9);
                int rightInt = (int)Math.floor(right - 1e-9);
                if(leftInt > rightInt) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                min = Math.min(min, n);
            }
        }
        System.out.println(min);
    }
}