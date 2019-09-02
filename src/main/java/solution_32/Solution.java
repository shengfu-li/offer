package solution_32;

/**
 *面试题32：从上到下打印二叉树。使用队列来进行层序遍历即可。注意Java中的Queue是一个接口，不能直接实例化，需要这样
 *   Queue<TreeNode> queue=new LinkedList();
 */



import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null) return new ArrayList();
        Queue<TreeNode> queue=new LinkedList();
        ArrayList<Integer> list=new ArrayList();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
        return list;
    }
}
