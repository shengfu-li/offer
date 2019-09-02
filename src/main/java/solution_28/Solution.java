package solution_28;

/**
 * 面试题28：判断是否是对称二叉树。首先我们要明白什么是镜像二叉树（这个可以去看第27题），然后我们定义一种新的遍历方法，即先遍历根节点，然后遍历右子树，最后遍历左子树
 * 与我们原先的先序遍历一起进行，依次比较当前Node的值。有一点需要注意的！就是我们需要将null值的比较也考虑进去，为了防止出现全是相同元素的情况。
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
    boolean isSymmetrical(TreeNode pRoot)
    {
        return travel(pRoot,pRoot);
    }
    boolean travel(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null) return true;
        else if(root1!=null&&root2!=null){
            if(root1.val==root2.val)
                return travel(root1.left,root2.right)&&travel(root1.right,root2.left);
            else
                return false;
        }else
            return false;

    }
}