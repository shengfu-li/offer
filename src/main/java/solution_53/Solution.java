package solution_53;

/**
 * 面试题53_1：数字k在排序数组中出现的次数
 * 需要判断k在排序数组中出现的次数，因为是排序数组，所以想到使用二分法！只需要找到第一个k出现的位置，以及最后一个k出现的位置即可。
 * 其实：最后一个k出现的位置可以通过查找第一个大于等于k+1的位置来实现！
 * 注意下我们自己的这个binarySearch函数，这个函数可能会查找失败。所以我们需要判断返回值是不是真的满足要求！
 *
 * if(array[index2]==k) return index2-index1+1;//没找到第一个大于等于k+1的元素
 *         else return index2-index1;//找到了第一个大于等于k+1的元素
 *
 * 还有需要注意一点，binarySearch中while循环的判断语句为：left<right，而不是left<=right！
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array==null ||array.length==0) return 0;
        int index1=binarySearch(array,k);
        int index2=binarySearch(array,k+1);
        if(array[index2]==k) return index2-index1+1;//没找到第一个大于等于k+1的元素
        else return index2-index1;//找到了第一个大于等于k+1的元素
    }

    //该函数可能会查找失败，若查找失败则会返回最后一个元素，即找不到
    public int binarySearch(int [] array,int k){
        int mid;
        int left=0;
        int right=array.length-1;
        //注意：判断条件不是left<=right
        //注意：判断条件不是left<=right
        while(left<right){
            mid=(left+right)/2;
            if(array[mid]>=k){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int [] nums={1,2,3};
        System.out.println(solution.binarySearch(nums,4));
    }
}