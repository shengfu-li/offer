package solution_14;

/*
 面试题14：将绳子问题。
 这个问题牛客网上没有，所以在leetcode上找了一个类似的：https://leetcode-cn.com/problems/integer-break/description/
 dp[i]表示正整数i所对应的最大的乘积(最少拆分为两个整数)
 关键语句是这条，请好好想想：int tmp=Math.max(j*(i-j),j*dp[i-j]);
*/
class Solution {
    public int integerBreak(int n) {
        int []dp=new int[60];
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            int maxVal=-1;
            for(int j=1;j<i;j++){
                int tmp=Math.max(j*(i-j),j*dp[i-j]);//这样写有个问题，例如i=3,j=1，请问此时的dp[i-j]=dp[2]是否已经计算了？
                if(tmp>maxVal)
                    maxVal=tmp;
            }
            dp[i]=maxVal;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n=4;
        System.out.printf("%d ",n>>1);
        System.out.printf("%d ",n&0x1);

    }

}