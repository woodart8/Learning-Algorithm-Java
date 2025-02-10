package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i=N-1; i>=0; i--) {
            for (int j=i+1; j<N; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        bw.write(answer+"\n");

        bw.flush();
        bw.close();
    }

}
