package tree;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.right = left;
        node.left = right;
        dfs(node.left);
        dfs(node.right);
    }

}
