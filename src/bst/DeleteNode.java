package bst;

public class DeleteNode {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(10);
		TreeNode root1 = new TreeNode(1);
		root1.right = new TreeNode(2);
		TreeNode result = new DeleteNode().deleteNode(root, 3);
		System.out.print(result);
	}
	
	public TreeNode deleteNode(TreeNode root, int key) {
		return delete(root, key);
	}
	
	private TreeNode delete(TreeNode node, int target) {
		if(node == null) {
			return null;
		}
		if(target < node.val) {
			node.left = delete(node.left, target);
		} else if(target > node.val) {
			node.right = delete(node.right, target);
		} else {
			if(node.left == null && node.right == null) {
				node = null;
			} else if(node.left != null && node.right == null) {
				node = node.left;
			} else if(node.left == null && node.right != null) {
				node = node.right;
			} else {
				int maxVal = findMaxVal(node.left);
				node.val = maxVal;
				node.left = delete(node.left, node.val);
			}
		}
		return node;
	}
	
	private int findMaxVal(TreeNode node) {
		if(node.right == null) {
			return node.val;
		}
		if(node.left == null && node.right == null) {
			return node.val;
		}
		return findMaxVal(node.right);
	}

}
