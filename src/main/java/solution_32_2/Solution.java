package solution_32_2;
/*面试题32.2：分行从上到下打印二叉树。与原先的层序序列相比，还要增加两个变量int currLineNum=1;//保存当前行的节点数目
*int nextLineNum=0;//保存下一行的节点数目
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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot==null) return new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(pRoot);
        int currLineNum=1;//保存当前行的节点数目
        int nextLineNum=0;//保存下一行的节点数目
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        while(!queue.isEmpty()){
            TreeNode node =queue.poll();
            list.add(node.val);
            currLineNum--;
            if(node.left!=null){
                queue.offer(node.left);
                nextLineNum++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nextLineNum++;
            }
            if(currLineNum==0){
                currLineNum=nextLineNum;
                nextLineNum=0;
                ArrayList<Integer> tmp=new ArrayList<>(list);
                result.add(tmp);
                list.clear();
            }
        }
        return result;
    }

}