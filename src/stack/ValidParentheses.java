package stack;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                boolean valid = !stk.isEmpty() && stk.pop() == '(';
                if (!valid) {
                    return false;
                }
            } else if (c == ']') {
                boolean valid = !stk.isEmpty() && stk.pop() == '[';
                if (!valid) {
                    return false;
                }
            } else if (c == '}') {
                boolean valid = !stk.isEmpty() && stk.pop() == '{';
                if (!valid) {
                    return false;
                }
            } else {
                stk.add(c);
            }
        }
        return stk.isEmpty();
    }

}
