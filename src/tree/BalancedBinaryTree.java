package tree;

public class BalancedBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.left = new TreeNode(16);
		root.right.left.left.left = new TreeNode(10);
		root.right.right = new TreeNode(17);
		new BalancedBinaryTree().isBalanced(root);
	}
	
	public boolean isBalanced(TreeNode root) {
		recursion(root, 0);
		return result;
        
    }
	
	boolean result = true;
	
	private int recursion(TreeNode node, int depth) {
		if(node == null) {
			return depth;
		}
		depth = depth+1;
		int left = recursion(node.left, depth);
		int right = recursion(node.right, depth);
		if(Math.abs(left-right) > 1) {
			result = false;
		}
		return Math.max(left, right); 
	}

}
