import java.util.Scanner;

public class File_integration_gold3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        int K;

        int[][] dp;
        int[] sum;
        int[] cost;
        int to;

        for(int i=0; i<T; i++) {
            K = sc.nextInt();
            dp = new int[K+1][K+1];
            sum = new int[K+1];
            cost = new int[K+1];

            for(int j=1; j<=K; j++) {
                cost[j] = sc.nextInt();
                sum[j] = sum[j-1] + cost[j];
            }

            for(int j=1; j<K; j++) {
                for(int from=1; from+j<=K; from++) {
                    to = from + j;
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int mid=from; mid<to; mid++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][mid] + dp[mid+1][to] + sum[to] - sum[from-1]);
                    }
                }
            }

            sb.append(dp[1][K] + "\n");

        }

        System.out.println(sb);
    }
}
