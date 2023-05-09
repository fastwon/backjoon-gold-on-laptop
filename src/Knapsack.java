import java.util.Scanner;

public class Knapsack {
    static int K;
    static int[][] WV;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        K = sc.nextInt();

        WV = new int[N][2];

        for(int i = 0; i < N; i++) {
            WV[i][0] = sc.nextInt();
            WV[i][1] = sc.nextInt();
        }

        dp = new int[N+1][K+1];

        for (int i = 0; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (WV[i-1][0] <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - WV[i-1][0]] + WV[i-1][1]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

