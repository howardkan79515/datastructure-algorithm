package recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
	
	
	public static void main(String[] args) {
		int result = new ClimbStairs().climbStairs(3);
		System.out.print(result);
	}
	
	Map<Integer, Integer> cache = new HashMap<>();
	
    public int climbStairs(int n) {
    	if(n <= 0) {
    		return 0;
    	}
    	if(n==1) {
    		return 1;
    	}
    	if(n==2) {
    		return 2;
    	}
    	if(cache.containsKey(n)) {
    		return cache.get(n);
    	}
		int result =  climbStairs(n-1) + climbStairs(n-2);     
		cache.put(n, result);
		return result;
    }


}
