import java.util.Scanner;

public class LIS_bitonic_subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] num = new int[N];

        int[] dp1 = new int[N];
        int[] dp2 = new int[N];

        for(int i=0; i<N; i++) {
            num[i] = sc.nextInt();
        }

        for(int i=0; i<N; i++) {

            for(int j=0; j<i; j++) {
                if(num[i] > num[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j]+1);
                }
            }
            for(int j=N-1; j>N-1-i; j--) {
                if(num[N-1-i] > num[j]){
                    dp2[N-1-i] = Math.max(dp2[N-1-i], dp2[j] + 1);
                }
            }
        }

        int[] dp = new int[N];

        int max = 0;

        for(int i=0; i<N; i++) {
            dp[i] = dp1[i] + dp2[i] + 1;

            max = max > dp[i] ? max : dp[i];
        }

        System.out.println(max);
    }
}

