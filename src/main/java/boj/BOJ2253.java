package boj;

import java.io.*;
import java.util.*;

public class BOJ2253 {

    private static final int INF = 0x3f3f3f3f;

    private static int N, M;
    private static final int[][] dp = new int[10001][501];
    private static final boolean[] invalid = new boolean[10001];

    private static int solve() {
        if (invalid[2]) return -1;

        dp[2][1] = 1;

        for (int i=3; i<=N; i++) {
            if (invalid[i]) continue;
            for (int v=1; v<500; v++) {
                if (i-v > 1 && !invalid[i-v]) {
                    dp[i][v] = Math.min(Math.min(dp[i - v][v - 1], dp[i - v][v]), dp[i - v][v + 1]) + 1;
                }
            }
        }

        int answer = INF;
        for (int i=1; i<500; i++) {
            answer = Math.min(answer, dp[N][i]);
        }

        if (answer == INF) {
            return -1;
        } else {
            return answer;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<=N; i++)
            Arrays.fill(dp[i], INF);

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            invalid[Integer.parseInt(st.nextToken())] = true;
        }

        bw.write(solve() + "\n");

        bw.flush();
        bw.close();
    }

}
