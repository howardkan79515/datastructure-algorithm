package tree;

public class SortedArrayToBST {
	
	public static void main(String[] args) {
		int[] nums = new int[] {-10,-3,0,5,9};

		new SortedArrayToBST().sortedArrayToBST(nums);
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode result = buildBST(nums, 0, nums.length-1);		
		return result;		
	}
	
	private TreeNode buildBST(int[] nums, int start, int end) {
		if(start > end) {
			return null;
		}
		int midValue = nums[(start+end)/2];
		TreeNode node = new TreeNode(midValue);
		node.left = buildBST(nums, start, (start+end)/2-1);
		node.right = buildBST(nums, (start+end)/2+1, end);
		return node;		
	}

}
