package solution_24;

/**
 *面试题24：反转链表。注意要将原始头结点的next设置为null！不然会死循环。
 * 也可以尝试下使用递归：
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null) return null;
        ListNode currNode=head;
        ListNode nextNode=head.next;
        ListNode tmpNode=null;
        head.next=null;//注意要将原始头结点的next设置为null
        while(nextNode!=null){
            tmpNode=nextNode.next;
            nextNode.next=currNode;
            currNode=nextNode;
            nextNode=tmpNode;
        }
        return currNode;
    }
}
