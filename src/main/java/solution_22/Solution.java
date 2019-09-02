package solution_22;
/**
 * 面试题22：链表中的第k个节点，注意要除了校验head!=null之外，还有校验k的范围,k>=1&&k<=链表的长度
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/*
public class solution_30 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<1) return null;
        ListNode listNode1=head;
        ListNode listNode2=head;
        for(int i=0;i<k-1;i++){
            if(listNode2.next!=null){
                listNode2=listNode2.next;
            }else{
                return null;
            }
        }
        while(listNode2.next!=null){
            listNode1=listNode1.next;
            listNode2=listNode2.next;
        }
        return listNode1;
    }
}*/
