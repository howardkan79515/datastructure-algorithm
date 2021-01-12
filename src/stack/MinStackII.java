package stack;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinStackII {
	
	
	int index = -1;
	
	int[] stack;
	
	PriorityQueue<Integer> heap = new PriorityQueue<>();

	public MinStackII() {
		this.stack = new int[10];
	}
	
	//Time complexity O(logN)
    public void push(int x) {
    	if(index >= stack.length-1) {
    		this.stack = Arrays.copyOf(stack, stack.length*2);
    	}
    	index++;
        stack[index] = x;  
        heap.add(x);
    }
    
    //Time complexity O(N)
    public void pop() {
        if(index == -1) {
        	return;
        }
        heap.remove(stack[index]);
        stack[index] = 0;
        index--;
    }
    
    public int top() {
		return stack[index];       
    }
    
    public int getMin() {
		return heap.peek();       
    }
    
    
}
