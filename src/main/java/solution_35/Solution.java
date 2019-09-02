package solution_35;

import java.util.*;
/**
 *面试题35：复杂链表的复制。分两步走，首先复制next节点，然后复制random节点。
 *在复制random结点的时候，需要从头开始遍历，非常耗时间，所以我们可以使用一个hash表，保存原节点与复制节点的映射关系
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        HashMap<RandomListNode,RandomListNode> myHash=new HashMap<RandomListNode,RandomListNode>();
        RandomListNode result=new RandomListNode(-1);
        RandomListNode currNode=pHead;
        RandomListNode resultNode=result;
        while(currNode.next!=null){
            resultNode.label=currNode.label;
            myHash.put(currNode,resultNode);
            resultNode.next=new RandomListNode(-1);
            resultNode=resultNode.next;
            currNode=currNode.next;
        }
        resultNode.label=currNode.label;
        resultNode.next=null;
        myHash.put(currNode,resultNode);

        currNode=pHead;
        resultNode=result;
        while(currNode!=null){
            if(myHash.containsKey(currNode.random))
                resultNode.random=myHash.get(currNode.random);
            else
                resultNode.random=null;
            currNode=currNode.next;
            resultNode=resultNode.next;
        }
        return result;
    }
}