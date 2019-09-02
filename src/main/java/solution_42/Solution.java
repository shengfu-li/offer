package solution_42;
/*
面试题42：连续子数组的最大和。有两种方法可以解，一种是贪心，另一种是动态规划。

 */

//1)使用贪心算法
//
/*public class solution_30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null ||array.length==0) return 0;
        int tmp=0,maxVal=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            tmp+=array[i];
            if(tmp>maxVal){//这两个位置的语句顺序不能变
                maxVal=tmp;
            }
            if(tmp<0){//这两个位置的语句顺序不能变
                tmp=0;
            }
        }
        return maxVal;
    }
}*/

//2)使用动态规划
//dp[i]表示以i结尾的连续子数组的最大和,所以dp[i]=max(dp[i-1]+array[i],array[i]);
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null ||array.length==0) return 0;
        int len=array.length;
        int []dp=new int[len];//dp[i]表示以i结尾的连续子数组的最大和
        dp[0]=array[0];
        int maxVal=dp[0];//记录下连续子数组的最大和
        for(int i=1;i<len;i++){
            dp[i]=Math.max(dp[i-1]+array[i],array[i]);
            if(dp[i]>maxVal)
                maxVal=dp[i];
        }
        return maxVal;
    }
}