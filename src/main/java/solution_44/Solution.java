package solution_44;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题44：数字序列中某一位的数字。首先我们可以用一个简单的方法，输入n，我们就走n步，每走一步时将n对应的字符放入队列中，然后出队。
 * 例如输入10，我们就把1和0两个字符放入队列中，然后出队。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int n=13;
        System.out.println(solution.printNum(n));
    }
    char printNum(int n){
        Queue<Character> queue=new LinkedList<>();
        char [] seq;
        char result='0';
        for(int i=0;i<=n;i++){
            seq=String.valueOf(i).toCharArray();
            for(int j=0;j<seq.length;j++)
                queue.offer(seq[j]);
            result=queue.poll();
        }
        return result;
    }
}
