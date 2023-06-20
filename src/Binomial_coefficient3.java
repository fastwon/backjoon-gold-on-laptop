import java.util.Scanner;

public class Binomial_coefficient3 {
    static int mod = 1000000007;
    static long[] factM;

    static void factorialMod(int a) {
        factM[0] = 1;

        for(int i=1; i<=a; i++) {
            factM[i] = (factM[i-1] * i) % mod;
        }
    }

    static long fastPow(long a, int b) {
        long powR = a % mod;

        if(b == 0) {
            return 1;
        }

        long temp = fastPow(a, b/2);

        if(b % 2 == 1) {
            powR = ((temp * temp) % mod * powR) % mod;
        } else {
            powR = (temp * temp) % mod;
        }

        return powR;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), K = sc.nextInt();

        factM = new long[N+1];

        factorialMod(N);

        long ans;

        if (K > N/2) K = N - K;
        if(K == 0) ans = 1;
        else {
            ans = ((factM[N] * fastPow(factM[K], mod-2)) % mod * fastPow(factM[N-K], mod-2)) % mod;
        }

        System.out.println(ans);
    }
}
