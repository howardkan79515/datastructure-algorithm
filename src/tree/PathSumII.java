package tree;

import java.util.ArrayList;
import java.util.List;




public class PathSumII {


	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		new PathSumII().pathSum(root, 22);
	}
	List<List<Integer>> result = new ArrayList<>();
	
	List<Integer> path = new ArrayList<>();
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		doTraversal(root, sum, 0);		
		return this.result;
	}
	
	private void doTraversal(TreeNode root, int sum, int pathSum) {
		if(root == null) {
			return;
		}
		path.add(root.val);
		pathSum = pathSum + root.val;
		if(root.left == null && root.right == null && pathSum == sum) {
			List<Integer> list = new ArrayList<>();
			list.addAll(path);
			result.add(list);
		}
		doTraversal(root.left, sum, pathSum);
		doTraversal(root.right, sum, pathSum);
		path.remove(path.size()-1);
	}


}
