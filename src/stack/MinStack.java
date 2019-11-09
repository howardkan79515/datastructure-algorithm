package stack;

import java.util.Arrays;

public class MinStack {
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(2);
		stack.push(1);
		stack.push(3);
		stack.pop();
		stack.top();
		stack.push(0);
		stack.getMin();
		stack.pop();
		stack.getMin();
		stack.pop();
		int min = stack.getMin();		
		System.out.print(min);
	}
	
	int[] stack;
	
	int index;
	
	int min;
	
	public MinStack() {
		this.stack = new int[10];     
		this.min = Integer.MAX_VALUE;
		this.index = 0;
    }
    
    public void push(int x) {
    	if(index == stack.length) {
    		this.stack = Arrays.copyOf(stack, stack.length*2);
    	}
    	stack[index] = x;
    	index++;
    	if(this.min > x) {
    		this.min = x;
    	}
    }
    
    public void pop() {
    	index--;
    	if(this.min == stack[index]) {
    		updateMin();
    	}
    	stack[index] = 0;
    }

	private void updateMin() {
		int min = Integer.MAX_VALUE;
    	for(int i = 0 ; i < index ; i++) {
    		if(stack[i] < min ) {
    			min = stack[i];
    		}
    	}
    	this.min = min;
	}
    
    public int top() {
    	return stack[index-1];   
    }
    
    public int getMin() {
    	return this.min;
    }

}
