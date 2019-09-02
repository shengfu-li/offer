package solution_29;
/**
 * 面试题29：顺时针打印矩阵。不难，只是需要注意边界条件！写代码前请自己画下各种矩阵的情况，防止有些情况下的重复打印！
 */

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int r1=0,r2=matrix.length-1,c1=0,c2=matrix[0].length-1;
        ArrayList<Integer> list=new ArrayList();
        while(r1<=r2&&c1<=c2){
            for(int i=c1;i<=c2;i++)
                list.add(matrix[r1][i]);
            for(int i=r1+1;i<=r2-1;i++)
                list.add(matrix[i][c2]);
            for(int i=c2;i>=c1;i--)
                //注意这个边界条件，防止重复打印！
                if(r1<r2)
                    list.add(matrix[r2][i]);
            for(int i=r2-1;i>=r1+1;i--)
                //注意这个边界条件，防止重复打印！
                if(c1<c2)
                    list.add(matrix[i][c1]);
            r1++;r2--;c1++;c2--;
        }
        return list;

    }
}