package tree;

public class BstFromPreorder {
	
	public static void main(String[] args) {
		new BstFromPreorder().bstFromPreorder(new int[] {8,5,1,7,10,12});
	}
		
	public TreeNode bstFromPreorder(int[] preorder) {
		TreeNode result = getTree(preorder, 0, preorder.length-1);		
		return result;
    }
	
	private TreeNode getTree(int[] nums, int start, int end) {
		if(start > end) {
			return null;
		}
		int val = nums[start];
		int left = start;
		int right = start;
		for(int i = start ; i <= end ; i++) {
			if(nums[i] < val) {
				left = i;
			} else if (nums[i]>val) {
				right = i;
			}
		}
		TreeNode treeNode = new TreeNode(val);
		treeNode.left = getTree(nums, start+1, left);
		treeNode.right = getTree(nums, left+1, right);
		return treeNode;		
	}

}
