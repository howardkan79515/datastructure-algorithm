package recursion;

import java.util.ArrayList;

import java.util.List;

public class Combinations {
	
	List<List<Integer>> result = new ArrayList<>();
	
	public static void main(String[] args) {
		new Combinations().combine(4, 2);
	}
	
	public List<List<Integer>> combine(int n, int k) {
		List<Integer> list = new ArrayList<>();
		doRecursion(n, k, 1, list);		
		return result;
        
    }
	
	private void doRecursion(int n, int k, int num, List<Integer> list) {
		if(list.size() == k) {
			result.add(new ArrayList<>(list));
			return;
		}
		for(int i = num ; i <= n ; i++) {
			list.add(i);
			doRecursion(n, k, i+1, list);
			list.remove(list.size()-1);
		}
		
	}

}
