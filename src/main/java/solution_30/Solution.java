package solution_30;
/**
 * 面试题30：包含min函数的栈。因为要求min函数的复杂度为O(1)，所有优先队列也不能用，只能使用空间换时间的方法！
 * 增加一个辅助栈，压栈时保留当前数据栈中最小的元素，辅助栈的大小于数据栈相同
 */

import java.util.Stack;

public class Solution {
    static Stack<Integer> dataStack=new Stack();
    static Stack<Integer> minStack=new Stack();

    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else{
            int minData=minStack.peek()>node?node:minStack.peek();
            minStack.push(minData);
        }
    }

    public void pop() {
        minStack.pop();
        dataStack.pop();
    }

    public int top() {

        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}