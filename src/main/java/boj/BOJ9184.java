package boj;

import java.io.*;
import java.util.*;

public class BOJ9184 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][][] dp = new int[51][51][51];

        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                Arrays.fill(dp[i][j], 1);
            }
        }

        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                for (int k = 1; k <= 50; k++) {
                    if (i > 20 || j > 20 || k > 20) {
                        dp[i][j][k] = 1048576;
                        continue;
                    }
                    if (i < j && j < k) {
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                        continue;
                    }
                    dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            if (a <= 0 || b <= 0 || c <=0 ) {
                bw.write("w(" + a + ", " + b + ", " + c + ") = " + 1 + "\n");
                continue;
            }

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + dp[a][b][c] + "\n");
        }

        bw.flush();
        bw.close();
    }

}
