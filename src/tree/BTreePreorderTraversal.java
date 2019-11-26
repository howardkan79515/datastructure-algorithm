package tree;

import java.util.ArrayList;
import java.util.List;

public class BTreePreorderTraversal {
	List<Integer> result = new ArrayList<>();
	
	public List<Integer> preorderTraversal(TreeNode root) {
		traversal(root);
		return result;
        
    }
	
	private void traversal(TreeNode node) {
		if(node == null) {
			return;
		}
		result.add(node.val);
		traversal(node.left);
		traversal(node.right);
	}

}
