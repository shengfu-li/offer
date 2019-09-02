package solution_7;

//面试题7 重建二叉树

import javax.swing.tree.TreeNode;

/**
 * Definition for binary tree
 **/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



public class solution_30 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root=func(pre,in,0,pre.length-1,0,in.length-1);
        return root;
    }
    public TreeNode func(int[] pre,int [] in,int preL,int preR,int inL,int inR){
        if(preL>preR||inL>inR)
            return null;
        int currVal=pre[preL];
        TreeNode node=new TreeNode(currVal);
        int index=inL;
        for(index=inL;index<=inR;index++){
            if(in[index]==currVal)
                break;
        }
        node.left=func(pre,in,preL+1,preL+index-inL,inL,index-1);
        node.right=func(pre,in,preL+index-inL+1,preR,index+1,inR);
        return node;
    }

}
