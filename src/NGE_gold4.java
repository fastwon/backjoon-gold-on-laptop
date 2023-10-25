import java.util.Scanner;
import java.util.Stack;

public class NGE_gold4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        int[] num = new int[len];

        for(int i=0; i<len; i++) {
            num[i] = sc.nextInt();
        }

        int[] ans = new int[len];

        Stack<Integer> si = new Stack<>();

        for(int i=0 , j = i+1; i<len; i++) {
            if(ans[i] != 0) {
                continue;
            }
            ans[i] = -1;
            si.push(i);
            while(!si.isEmpty() && j < len) {

                if(num[si.peek()] >= num[j]) {
                    si.push(j);
                } else {
                    ans[si.pop()] = num[j];
                    j--;
                }
                j++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i : ans) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}