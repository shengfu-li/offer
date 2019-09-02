package solution_33;

/**
 * 面试题33：二叉搜索树的后序遍历。给定一个序列，判断是不是一个合法的后后序遍历序列。因为是搜索树，所有可以以最后一个元素为中间点，将序列拆分成两个。
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0) return false;
        else  return verify(sequence,0,sequence.length-1);
    }
    boolean verify(int [] sequence,int first,int last){
        if(first>last) return true;
        if(first==last) return true;
        int currIndex=first;
        while(currIndex<last && sequence[currIndex]<sequence[last]){
            currIndex++;
        }
        boolean flag1,flag2;
        if(currIndex<last){//说明碰到比末尾元素大的值
            int tmpIndex=currIndex;
            while(currIndex<last && sequence[currIndex]>sequence[last])
                currIndex++;
            if(currIndex<last){//说明碰到了比末尾元素小的值，这种情况不是合格的后序遍历序列
                return false;
            }else{
                return verify(sequence,first,tmpIndex-1) && verify(sequence,tmpIndex,last-1);
            }
        }else{//说明没有碰到比末尾元素大的值
            return verify(sequence,first,currIndex-1);
        }

    }
}