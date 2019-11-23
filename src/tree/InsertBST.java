package tree;

public class InsertBST {
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(20);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(30);
		
		root.right = new TreeNode(60);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(70);
		new InsertBST().insertIntoBST(root, 5);
	}
	
    public TreeNode insertIntoBST(TreeNode root, int val) {
    	insert(root, 5);
		return root;
        
    }
    
    private void insert(TreeNode node, int val) {
    	if(node == null) {
    		return;
    	}
    	int nodeVal = node.val;
    	if(val < nodeVal) {
    		if(node.left == null) {
    			node.left = new TreeNode(val);
    			return;
    		}
    		insert(node.left, val);
    	} else {
    		if(node.right == null) {
    			node.right = new TreeNode(val);
    			return;
    		}
    		insert(node.right, val);
    	}
    	
    }

}

