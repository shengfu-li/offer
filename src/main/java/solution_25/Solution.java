package solution_25;

//比较简单，不需要重新申请空间，只需要在原先的两个链表上操作即可，注意：别让链表断裂

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head;
        if(list1.val<list2.val) head=list1;
        else head=list2;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                ListNode tmp=list1.next;
                list1.next=list2;
                list1=tmp;
            }else{
                ListNode tmp=list2.next;
                list2.next=list1;
                list2=tmp;
            }
        }
        return head;
    }
}