package solution_11;

import java.util.ArrayList;
/*
顺序查找大家都会。这里我们使用二分查找的思想，复杂度能到O(log(N))
*/
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;

        int left=0,right=array.length-1;
        while(left<right){
            int mid=(right-left)/2+left;
            if(array[mid]==array[left]&&array[mid]==array[right])//当出现左边界元素、右边界元素、中间元素相同的情况时，切换为顺序查找
                return findMin(array,left,right);
            if(array[mid]<array[right]){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return array[left];
    }
    public int findMin(int []array,int left,int right){//当出现左边界元素、右边界元素、中间元素相同的情况时，切换为顺序查找
        int minVal=array[left];
        for(int i=left;i<=right;i++){
            if(minVal>array[i])
                minVal=array[i];
        }
        return minVal;
    }
}