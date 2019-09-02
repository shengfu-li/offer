package solution_18_2;

/**
 * 面试题18：删除链表中连续重复的节点
 有一些特殊情况需要注意：例如全是重复节点1->1->1->1,或者只有一个节点1。

 */

  class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args) {
        int[] nums={1,1,1};
        ListNode pHead=new ListNode(nums[0]);
        ListNode currNode=pHead;
        for(int i=1;i<nums.length;i++){
            ListNode node=new ListNode(nums[i]);
            currNode.next=node;
            currNode=currNode.next;
        }
        ListNode tmp=deleteDuplication(pHead);
        while(tmp!=null){
            System.out.printf("%d ",tmp.val);
            tmp=tmp.next;
        }
    }
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null) return null;
        ListNode preNode=pHead;
        ListNode currNode=pHead;
        ListNode nextNode=pHead.next;
        while(nextNode!=null){
            while(nextNode!=null&&currNode.val!=nextNode.val){//找到当前节点值和下一个节点值相同的地方
                preNode=currNode;
                currNode=nextNode;
                nextNode=nextNode.next;
            }
            while(nextNode!=null&&nextNode.next!=null&&nextNode.val==nextNode.next.val){//继续寻找，直到重复节点的末尾
                nextNode=nextNode.next;
            }
            if(nextNode!=null){
                if(preNode!=currNode){//当前头节点不需要删除
                    preNode.next=nextNode.next;
                    currNode=preNode.next;
                    nextNode=currNode==null?null:currNode.next;
                }else{//preNode==currNode,说明当前的头节点也要删除
                    currNode=nextNode.next;
                    preNode=nextNode.next;
                    nextNode=currNode==null?null:currNode.next;
                    pHead=currNode;
                }

            }

        }
        return pHead;
    }
}