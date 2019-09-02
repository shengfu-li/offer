package solution_26;

/**面试题26：分为两步走，1）在左子树中遍历，找到所有A树节点，其中这些节点的值等于B树根节点的值，将这些节点放在一个ArrayList中。
*2）从ArrayList中取出节点，依次判断以该节点为根的子树中包不包含B树
* 注意：travle语句中 这两条语句if(root2==null) return true;以及if(root1==null) return false;的执行顺序不能更换！因为要求是B树是不是A树的子树
*
 * */

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    static ArrayList<TreeNode> listNodes=new ArrayList();

    public static void main(String[] args) {
        //char[] str1={'8','8','7','9','3','#','#','#','#','4','7'};
        //char[] str2={'8','9','2'};
        TreeNode node1[] = new TreeNode[7];
        node1[0] = new TreeNode(8);
        node1[1] = new TreeNode(8);
        node1[2] = new TreeNode(7);
        node1[3] = new TreeNode(9);
        node1[4] = new TreeNode(3);
        node1[5] = new TreeNode(4);
        node1[6] = new TreeNode(7);

        node1[0].left = node1[1];
        node1[0].right = node1[2];
        node1[1].left = node1[3];
        node1[1].right = node1[4];
        node1[4].left = node1[5];
        node1[4].right = node1[6];

        TreeNode node2[] = new TreeNode[3];
        node2[0] = new TreeNode(8);
        node2[1] = new TreeNode(9);
        node2[2] = new TreeNode(2);
        node2[0].left = node2[1];
        node2[0].right = node2[2];
        Solution sl = new Solution();
        System.out.println(sl.HasSubtree(node1[0],node2[0]));
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag=false;
        findNode(root1,root2.val);
        for(int i=0;i<listNodes.size();i++){
            if(travel(listNodes.get(i),root2)){
                flag=true;
                break;
            }
        }
        return flag;
    }
    static void findNode(TreeNode root1,int val){
        if(root1==null) return ;
        if(root1.val==val){
            listNodes.add(root1);
        }
        if(root1.left!=null){
            findNode(root1.left,val);
        }
        if(root1.right!=null){
            findNode(root1.right,val);
        }

    }

    static boolean travel(TreeNode root1, TreeNode root2){
        if(root2==null)//
            return true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        boolean flag1=false,flag2=false;
        flag1= travel(root1.left,root2.left);
        flag2= travel(root1.right,root2.right);
        return flag1&&flag2;
    }
}