package solution_8;

/*
分为两种情况，总结归纳如下：1）当前节点的右子树不为空，则下一个节点为右子树的最左边节点。2）当前节点的右子树为空，则下一个节点为：一直往上找，直到某个节点为它父节点的左节点
*/

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/

/*
public class solution_30 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode rightNode=pNode.right;
        if(rightNode!=null){
            TreeLinkNode tmpNode=rightNode.left;
            if(tmpNode==null){
                return rightNode;
            }else{
                while(tmpNode.left!=null)
                    tmpNode=tmpNode.left;
                return tmpNode;
            }

        }else{
            TreeLinkNode fatherNode=pNode.next;
            while(fatherNode!=null&&fatherNode.right==pNode){
                pNode=fatherNode;
                fatherNode=fatherNode.next;
            }
            return fatherNode;
        }
    }
}*/
