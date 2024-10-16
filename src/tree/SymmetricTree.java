package tree;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        dfs(root.left, root.right);
        return result;
    }

    boolean result = true;

    private void dfs(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            result = false;
            return;
        } else if (left != null && right == null) {
            result = false;
            return;
        } else if (left == null && right == null) {
            return;
        } else if (left.val != right.val) {
            result = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}
