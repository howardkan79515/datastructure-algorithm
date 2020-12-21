package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class IncreasingSubsequences {
	
	public static void main(String[] args) {
		new IncreasingSubsequences().findSubsequences(new int[] {4, 6, 7, 7});
	}
	
	Set<List<Integer>> result = new HashSet<>();
	
	public List<List<Integer>> findSubsequences(int[] nums) {
		if(nums.length == 0) {
			return new ArrayList<>();
		}
		dfs(nums, new ArrayList<>(), 0);		
		return new ArrayList<>(result);
        
    }
	
	private void dfs(int[] nums, List<Integer> list, int index) {
		for(int i = index ; i < nums.length ; i++) {
			if(list.isEmpty() || list.get(list.size()-1) <= nums[i]) {
				list.add(nums[i]);
				if(list.size() > 1) {
					result.add(new ArrayList<>(list));
				}
				dfs(nums, list, i+1);
				if(!list.isEmpty()) {
					list.remove(list.size()-1);
				}
			}
		}
	}
	

}
