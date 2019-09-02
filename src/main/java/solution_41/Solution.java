package solution_41;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *面试题41：数据流中的中位数。此时我们需要两个堆，中位数左边一个大顶堆，中位数右边一个小顶堆。
 * 奇数的时候放在左边堆，偶数的时候放右边堆。
 */
public class Solution {
    int n=0;
    PriorityQueue<Integer> leftQueue=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1<o2)
                return 1;
            else
                return -1;
        }
    });
    PriorityQueue<Integer> rightQueue=new PriorityQueue<>();
    public void Insert(Integer num) {
        n++;
        if(n%2!=0){//奇数的时候放在左边
            rightQueue.offer(num);
            leftQueue.offer(rightQueue.poll());

        }else{//偶数的时候放在右边
            leftQueue.offer(num);
            rightQueue.offer(leftQueue.poll());
        }

    }

    public Double GetMedian() {
        if(n%2!=0){
            return new Double(leftQueue.peek());
        }else{
            return new Double((leftQueue.peek()+rightQueue.peek())/2.0);
        }

    }


}