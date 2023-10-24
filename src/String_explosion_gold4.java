import java.util.Scanner;
import java.util.Stack;

public class String_explosion_gold4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ss = sc.next();
        String bomb = sc.next();

        int bombSize = bomb.length();
        char lastBombChar = bomb.charAt(bombSize - 1);

        Stack<Character> stch = new Stack<>();

        boolean isMatchedBombString;

        for(int i=0; i<ss.length(); i++) {
            char currentChar = ss.charAt(i);
            stch.push(currentChar);

            if(currentChar == lastBombChar && stch.size() >= bombSize) {
                isMatchedBombString = true;

                for(int j=0; j<bombSize; j++) {
                    if(stch.get(stch.size() - bombSize + j) != bomb.charAt(j)) {
                        isMatchedBombString = false;
                        break;
                    }
                }

                if(isMatchedBombString) {
                    for(int j=0; j<bombSize; j++)
                        stch.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if (stch.isEmpty())
            sb.append("FRULA");
        else
            for (char c : stch)
                sb.append(c);

        System.out.println(sb);
    }
}
