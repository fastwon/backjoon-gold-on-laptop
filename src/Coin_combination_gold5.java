import java.util.Arrays;
import java.util.Scanner;

public class Coin_combination_gold5 {
    static Integer[][] dp;
    static int[] coin;
    static int k;
    static int count;

    static int calCoin(int idx, int sum) {
        if(sum == k) {
            dp[idx][sum] = 1;
            count++;
            return dp[idx][sum];
        }

        if(dp[idx][sum] != null) {
            if(dp[idx][sum] != 0) {
                count += dp[idx][sum];
            }
            return dp[idx][sum];
        }

        dp[idx][sum] = 0;

        if(coin[idx] <= k - sum) {
            dp[idx][sum] += calCoin(idx, sum+coin[idx]);
        }
        if(idx>0) {
            dp[idx][sum] += calCoin(idx-1, sum);
        }

        return dp[idx][sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        k = sc.nextInt();

        dp = new Integer[n][k+1];

        coin = new int[n];

        for(int i=0; i<n; i++) {
            coin[i] = sc.nextInt();
        }

        Arrays.sort(coin);

        calCoin(n-1, 0);

        System.out.println(count);
    }
}