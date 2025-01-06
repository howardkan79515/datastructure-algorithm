package dfs;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{1,2,3});
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return result;
    }


    private void dfs(int[] nums, int i, List<Integer> list) {
        if (i > nums.length-1) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        i = i+1;
        dfs(nums, i, list);
        list.remove(list.size()-1);
        dfs(nums, i, list);
        System.out.println("i:"+i);
    }
}
