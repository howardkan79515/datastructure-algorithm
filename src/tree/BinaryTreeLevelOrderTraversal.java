package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(17);
		new BinaryTreeLevelOrderTraversal().levelOrder(null);
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		List<Integer> layer = new ArrayList<>();
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node == null) {
				result.add(layer);
				layer = new ArrayList<>();
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				continue;
			}
			layer.add(node.val);
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
		
		return result;
        
    }

}
