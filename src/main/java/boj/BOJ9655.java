package boj;

import java.io.*;

public class BOJ9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N+1];
        dp[0] = false;
        dp[1] = true;

        for (int i=2; i<=N; i++) {
            if (i == 2) {
                dp[i] = false;
                continue;
            }
            dp[i] = !dp[i-1] || !dp[i-3];
        }

        bw.write(dp[N] ? "SK" : "CY");

        bw.flush();
        bw.close();
    }

}
