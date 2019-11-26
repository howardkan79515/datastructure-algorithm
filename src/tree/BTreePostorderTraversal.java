package tree;

import java.util.ArrayList;
import java.util.List;

public class BTreePostorderTraversal {
	
	List<Integer> result = new ArrayList<>();
	
	public List<Integer> postorderTraversal(TreeNode root) {
		traversal(root);
		return result;
        
    }
	
	private void traversal(TreeNode node) {
		if(node == null) {
			return;
		}
		traversal(node.left);
		traversal(node.right);
        result.add(node.val);
	}

}
