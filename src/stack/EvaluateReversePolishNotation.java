package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if ("+".equals(token)) {
                stk.add(stk.pop()+stk.pop());
            } else if ("-".equals(token)) {
                int v1 = stk.pop();
                int v2 = stk.pop();
                stk.add(v2-v1);
            } else if ("*".equals(token)) {
                stk.add(stk.pop()*stk.pop());
            } else if ("/".equals(token)) {
                int v1 = stk.pop();
                int v2 = stk.pop();
                stk.add(v2/v1);
            } else {
                stk.add(Integer.valueOf(token));
            }
        }
        return stk.pop();
    }

}
