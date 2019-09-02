package solution_54;

/**
 * 面试题：二叉搜索树的第k个节点
 * 很简单，只需要一趟中序遍历即可！
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
    private int cnt=0;
    private TreeNode resultNode;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null) return null;
        inOrderTravel(pRoot,k);
        return resultNode;
    }

    void inOrderTravel(TreeNode node,int k){
        if(node.left!=null)
            inOrderTravel(node.left,k);
        cnt++;
        if(cnt==k)
            resultNode=node;
        if(node.right!=null)
            inOrderTravel(node.right,k);
    }

}