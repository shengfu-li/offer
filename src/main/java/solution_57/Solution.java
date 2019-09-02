package solution_57;

/**
 * 面试题57.2：和为s的连续正数序列
 * 使用两个数，一个是small，表示序列的最小值,一个是big，表示序列的最大值。如果序列和小于sum，big++;如果序列和大于sum，small++;
 */

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if(sum==0) return null;
        int small=1;
        int big=2;
        int tmpSum=small+big;
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        for(;big<sum;){
            if(tmpSum==sum){
                ArrayList<Integer> list=new ArrayList<>();
                for(int i=small;i<=big;i++)
                    list.add(i);
                lists.add(list);
                big++;
                tmpSum+=big;
            }else if(tmpSum<sum){
                big++;
                tmpSum+=big;
            }else{
                tmpSum-=small;
                small++;
            }
        }
        return lists;
    }
}