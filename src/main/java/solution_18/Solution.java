package solution_18;
/*
在O（1）时间复杂的度的情况下删除一个节点，只需要将要删除节点的值赋给上一节点，然后再将指针指向要删除节点的下一个节点即可。
需要注意的是：如果被删除节点是尾节点，那么需要从头开始遍历，找到该节点的上一个节点。如果要删除的是头结点，则直接返回null即可。
 */
public class Solution {
     class Node{
        int val;
        Node next;
    }

    //返回值是头结点
    public Node deleteNode(Node head,Node tobeDelete){
         if(head==null||tobeDelete==null)
             return null;
         Node nextNode=tobeDelete.next;
         if(nextNode!=null) {//说明要删除的点不是根节点
             tobeDelete.val = nextNode.val;
             tobeDelete.next = nextNode.next;
         }else if(head!=tobeDelete){//说明要删除的点是根节点，此时需要们从头结点开始遍历
            Node currNode=head;
            while(currNode.next!=tobeDelete)
                currNode=currNode.next;
            nextNode.next=null;
         }else{//要删除的点为根节点
             return null;
         }
         return head;
    }
    public static void main(String[] args) {

    }
}
