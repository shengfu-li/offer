package solution_59;
/*
面试题59：队列的最大值。
我们使用了一个优先队列PriorityQueue，因为默认是小顶堆，所以我们需要在构造函数中传入new Comparator，重写其中的compare方法。
注意：我们可以使用remove（Object o）移除指定的元素！
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                    return -1;
                else
                   return 1;
            }
        });  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 1, j = i + size - 1; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i - 1]);//删除指定元素！
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
