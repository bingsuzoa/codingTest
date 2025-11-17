import java.util.*;
import java.io.*;

class Main {
    static int[][] goals = new int[8][7];
    static boolean[][] visited = new boolean[8][7];
    static boolean[][] dominos = new boolean[7][7];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < goals.length; i++) {
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                goals[i][j] = input.charAt(j) - '0';
            }
        }
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int r, int c) {
        if(r == 8) {
            answer++;
            return;
        }
        if(c == 7) {
            dfs(r+1, 0);
            return;
        }

        if(!visited[r][c]) {
            visited[r][c] = true;
            int curNum = goals[r][c];

            for(int i = 0; i < 2; i++) {
                if(i == 0) {
                    int nextR = r+1;
                    int nextC = c;

                    if(nextR >= 8 || nextC >= 7) {
                        continue;
                    }

                    if(visited[nextR][nextC]) {
                        continue;
                    }

                    int pairNum = goals[nextR][nextC];
                    if(dominos[curNum][pairNum]) {
                        continue;
                    }

                    visited[nextR][nextC] = true;
                    dominos[curNum][pairNum] = true;
                    dominos[pairNum][curNum] = true;
                    dfs(r, c+1);
                    visited[nextR][nextC] = false;
                    dominos[curNum][pairNum] = false;
                    dominos[pairNum][curNum] = false;
                }
                if(i == 1) {
                    int nextR = r;
                    int nextC = c+1;
                    if(nextR >= 8 || nextC >= 7) {
                        continue;
                    }
                    int pairNum = goals[nextR][nextC];
                    if(visited[nextR][nextC]) {
                        continue;
                    }
                    if(dominos[curNum][pairNum]) {
                        continue;
                    }
                    visited[nextR][nextC] = true;
                    dominos[curNum][pairNum] = true;
                    dominos[pairNum][curNum] = true;
                    dfs(nextR, nextC);
                    visited[nextR][nextC] = false;
                    dominos[curNum][pairNum] = false;
                    dominos[pairNum][curNum] = false;
                }
            }
            visited[r][c] = false;
        } else {
            dfs(r, c+1);
        }
    }
}