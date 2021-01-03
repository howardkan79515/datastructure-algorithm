package stack;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinStackII {
	
	public static void main(String[] args) {
		
	}
	
	int index = -1;
	
	int[] stack;
	
	PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

	public MinStackII(int size) {
		this.stack = new int[size];
	}
    
    public void push(int x) {
    	if(index >= stack.length-1) {
    		return;
    	}
    	index++;
        stack[index] = x;  
        heap.add(x);
    }
    
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
