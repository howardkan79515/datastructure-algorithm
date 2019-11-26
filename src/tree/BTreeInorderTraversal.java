package tree;

import java.util.ArrayList;
import java.util.List;

public class BTreeInorderTraversal {
	
	List<Integer> result = new ArrayList<>();
	
	public List<Integer> inorderTraversal(TreeNode root) {
		traversal(root);
		return result;
        
    }
	
	private void traversal(TreeNode node) {
		if(node == null) {
			return;
		}
		traversal(node.left);
		result.add(node.val);
		traversal(node.right);
	}

}
