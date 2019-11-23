package tree;



public class PathSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(5);
		root.left.left.left.left.left = new TreeNode(6);
		new PathSum().hasPathSum(root, 6);
	}
	
	boolean result = false;
	
	public boolean hasPathSum(TreeNode root, int sum) {
		doTraversal(root, sum, 0);
		return result;       
	}
	private void doTraversal(TreeNode root, final int sum, int pathSum) {
		if(root == null) {
			return;
		}
		pathSum = pathSum + root.val;
		if(root.left == null && root.right == null && pathSum == sum) {
			this.result = true;
		}
		doTraversal(root.left, sum, pathSum);
		doTraversal(root.right, sum, pathSum);
	}


}
