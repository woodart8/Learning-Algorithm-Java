package boj;

import java.io.*;

public class BOJ11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] l = new int[N];
        int[] dp = new int[N];
        String[] ns = br.readLine().split(" ");

        for (int i=0; i<N; i++) {
            dp[i] = l[i] = Integer.parseInt(ns[i]);
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (l[j] < l[i]) {
                    dp[i] = Math.max(dp[j]+l[i], dp[i]);
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
