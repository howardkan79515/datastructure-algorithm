package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	List<List<Integer>> result = new ArrayList<>();
	
	public static void main(String[] args) {
		new CombinationSum().combinationSum(new int[] {2, 3, 6, 7}, 7 );
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		calSum(candidates, target, new ArrayList<>(), 0, 0);		
		return result;
        
    }
	
	private void calSum(int[] candidates, int target, List<Integer> list, int index, int sum) {
		if(sum >= target) {
			if(sum == target) {
				result.add(new ArrayList<>(list));
			}
			return;
		}
		for(int i = index ; i < candidates.length ; i++) {
			list.add(candidates[i]);
			sum = sum + candidates[i];
			calSum(candidates, target, list, i, sum);
			sum = sum - list.get(list.size()-1);
			list.remove(list.size()-1);
		}
		
	}

}
