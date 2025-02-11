package boj;

import java.util.*;
import java.io.*;

public class BOJ2565 {

    static class Cord implements Comparable<Cord> {
        int s,e;

        Cord(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Cord o) {
            if (this.s != o.s) return this.s-o.s;
            else return this.e-o.s;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Cord> l = new ArrayList<>();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l.add(new Cord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(l);

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int max = 0;
        for (int i=N-2; i>=0; i--) {
            for (int j=N-1; j>i; j--) {
                if (l.get(i).e >= l.get(j).e) continue;
                dp[i] = Math.max(dp[i], dp[j]+1);
                max = Math.max(max, dp[i]);
            }
        }

        bw.write(N-max+"\n");

        bw.flush();
        bw.close();
    }

}
