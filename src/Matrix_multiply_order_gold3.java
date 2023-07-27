import java.util.Scanner;

public class Matrix_multiply_order_gold3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] matrix = new int[N][2];

        for(int i=0; i<N; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }

        int[][] dp = new int[N][N];

        for(int i=1; i<N; i++) {
            for(int j=0; j+i<N; j++) {
                int x = j+i;
                dp[j][x] = Integer.MAX_VALUE;
                for(int k=j; k<x; k++) {
                    dp[j][x] = Math.min(dp[j][x], dp[j][k] + dp[k+1][x] + matrix[j][0]*matrix[k+1][0]*matrix[x][1]);
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
}

