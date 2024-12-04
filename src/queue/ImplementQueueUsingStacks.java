package queue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> stk1;

    Stack<Integer> stk2;

    public ImplementQueueUsingStacks() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    public void push(int x) {
        stk1.add(x);
    }

    public int pop() {
        if (stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.add(stk1.pop());
            }
        }
        return stk2.pop();
    }

    public int peek() {
        if (stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.add(stk1.pop());
            }
        }
        return stk2.peek();
    }

    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();
    }

}
