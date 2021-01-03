package stack;

import java.util.Arrays;

public class MinStackIII {
	
	int[] stack;
    
    int min = Integer.MAX_VALUE;
    
    int index = -1;

    /** initialize your data structure here. */
    public MinStackIII() {
        this.stack = new int[10];
    }
    
    public void push(int x) {
        if(x < min) {
            min = x;
        }
        index++;
        if(index > stack.length-1){
            stack = Arrays.copyOf(stack, stack.length*2);
        }
        stack[index] = x;
        
    }
    
    public void pop() {
        stack[index] = 0;
        index--;
        min = Integer.MAX_VALUE;
        for(int i = 0 ; i <= index ; i++) {
            if(stack[i] < min) {
                min = stack[i];
            }
        }
    }
    
    public int top() {
        return stack[index];
    }
    
    public int getMin() {
        return this.min;
    }

}
