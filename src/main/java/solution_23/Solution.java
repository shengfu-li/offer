package solution_23;

/**
 * 面试题23：链表中环的入口节点。使用两个指针，第一个指针先走n步（n为环中节点的个数），然后两个指针一起走，两个指针第一次遇到一起的那个节点就是环的入口节点。
 * 现在的问题是：如何计算环中节点的个数？让一个指针先走，并且一次走两步，如果有环的话，先走的那个节点一定会碰到后走的那个节点。
 * 注意：链表中也有可能不包含环！这种情况也需要考虑
 */

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null) return null;
        if(pHead.next==pHead) return pHead;
        ListNode node1=pHead;
        ListNode node2=pHead.next;
        int n=0;
        while(node1!=null&&node2!=null&&node2.next!=null&&node1!=node2){
            node1=node1.next;
            node2=node2.next.next;
        }
        if(node1==null||node2==null||node2.next==null)//说明该链表中不存在环
            return null;
        else{
            ListNode tmp=node1;
            node2=node2.next;
            n++;
            while(node2!=tmp){
                n++;
                node2=node2.next;
            }
        }
        //以上为计算环中节点的个数n
        node1=pHead;
        node2=pHead;
        for(int i=0;i<n;i++)
            node2=node2.next;
        while(node1!=node2){
            node1=node1.next;
            node2=node2.next;
        }
        return node1;
    }
}