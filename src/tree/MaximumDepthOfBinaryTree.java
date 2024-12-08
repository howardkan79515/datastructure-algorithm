package tree;

public class MaximumDepthOfBinaryTree {

    int max = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        depth++;
        max = Math.max(max, depth);
        dfs(node.left, depth);
        dfs(node.right, depth);
    }

}
