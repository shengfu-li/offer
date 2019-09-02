package solution_55;

/**
 * 面试题55：二叉树的深度
 * 只需要后序遍历即可！
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root==null) return 0;
        return postOrderTravel(root);
    }
    public int postOrderTravel(TreeNode root){
        int leftDepth=0,rightDepth=0;
        if(root.left!=null)
            leftDepth=postOrderTravel(root.left);
        if(root.right!=null)
            rightDepth=postOrderTravel(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}