package tree;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    List<Integer> nodes = new ArrayList<>();

    int index = 0;

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        this.nodes.add(node.val);
        dfs(node.right);
    }

    public int next() {
        if (index > nodes.size()-1) {
            //Invalid case
            return -1;
        }
        int res = nodes.get(index);
        index++;
        return res;
    }

    public boolean hasNext() {
        if (index > nodes.size()-1) {
            return false;
        }
        return true;
    }

}
