package solution_31;

/**
 * 面试题31：栈的压入和弹出。这个只需要模拟栈的压入弹出就好。注意：代码写完后一定要自己找几个例子测试下。
 */

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int index=0;
        for(int i=0;i<pushA.length;i++){
            if(pushA[i]==popA[index]){
                index++;
                continue;
            }
            stack.push(pushA[i]);
        }
        boolean flag=true;
        while(!stack.isEmpty()){
            if(stack.pop()!=popA[index]){
                flag=false;
                break;
            }else{
                index++;
            }
        }
        return flag;
    }
}