import java.util.Scanner;
import java.util.Stack;

public class NGF_gold3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] num = new int[N];

        int max = 0;

        for(int i=0; i<N; i++) {
            num[i] = sc.nextInt();

            max = Math.max(max, num[i]);
        }

        int[] count = new int[max+1];

        for(int i : num) {
            count[i]++;
        }

        Stack<Integer> si = new Stack<>();

        int[] ans = new int[N];

        for(int i=0, j=i+1; i<N; i++) {
            if(ans[i] != 0) {
                continue;
            }

            si.push(i);
            ans[i] = -1;

            while(!si.isEmpty() && j<N) {
                if(count[num[si.peek()]] < count[num[j]]) {
                    ans[si.pop()] = num[j];
                } else {
                    si.push(j);
                    j++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int a : ans) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}
