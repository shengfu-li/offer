package solution_27;

//面试题27：求镜像二叉树。用一个后序遍历即可


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public void Mirror(TreeNode root) {

        reverse(root);
    }
    TreeNode reverse(TreeNode root){
        if(root==null) return null;
        TreeNode leftNode=reverse(root.left);
        TreeNode rightNode=reverse(root.right);
        root.left=rightNode;
        root.right=leftNode;
        return root;
    }
}