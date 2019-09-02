package solution_47;

import java.util.*;

/**
 * 面试题47：礼物的最大价值。地址为：https://www.nowcoder.com/questionTerminal/72a99e28381a407991f2c96d8cb238ab
 * 使用了一个二维辅助数组,dp[i][j]表示从(i,j)到右下角所能得到的最大值。
 * 核心递推公式为：dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1])+board[i][j];
 * 但是我们是否真的需要二维数组的辅助空间呢？我们来尝试下使用一维的辅助数组。
 */
/*public class solution_30 {
    public int getMost(int[][] board) {
        if(board==null ||board.length==0) return 0;
        int rows=board.length;
        int cols=board[0].length;
        int [][]dp=new int[rows][cols];
        for(int i=0;i<cols;i++)
            Arrays.fill(dp[i],0);
        dp[rows-1][cols-1]=board[rows-1][cols-1];

        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=0;j--){
                if(i+1<=rows-1 && j+1<=cols-1)
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1])+board[i][j];
                else if(i+1<=rows-1)
                    dp[i][j]=dp[i+1][j]+board[i][j];
                else if(j+1<=cols-1)
                    dp[i][j]=dp[i][j+1]+board[i][j];
            }
        }

        return dp[0][0];
    }
}*/

/*
由于二维辅助数组的使用率不高，所以我们尝试下只使用一维的辅助数组！
 */
public class Solution {
    public int getMost(int[][] board) {
        if(board==null ||board.length==0) return 0;
        int rows=board.length;
        int cols=board[0].length;
        int []dp=new int[cols];
        Arrays.fill(dp,0);
        dp[cols-1]=board[rows-1][cols-1];

        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=0;j--){
                if(i+1<=rows-1 && j+1<=cols-1)
                    dp[j]=Math.max(dp[j],dp[j+1])+board[i][j];
                else if(i+1<=rows-1)
                    dp[j]=dp[j]+board[i][j];
                else if(j+1<=cols-1)
                    dp[j]=dp[j+1]+board[i][j];
            }
        }

        return dp[0];
    }
}