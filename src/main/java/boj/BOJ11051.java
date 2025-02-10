package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][N+1];

        for (int i=0; i<=N; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int n=2; n<=N; n++) {
            for (int k=1; k<n; k++) {
                dp[n][k] = (dp[n - 1][k - 1] + dp[n - 1][k])%10007;
            }
        }

        bw.write(dp[N][K]+"\n");

        bw.flush();
        bw.close();
    }

}
