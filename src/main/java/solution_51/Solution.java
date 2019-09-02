package solution_51;

/**
 * 面试题51：数组中的逆序对
 * 利用归并排序的思想，进行统计（简单起见，使用递归版本的归并排序！）
 */
public class Solution {
    private long cnt = 0;
    private int[] tmp;

    public int InversePairs(int[] nums)
    {
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int l, int r)
    {
        if (l >= r)
            return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid,mid+1, r);
    }

    private void merge(int[] nums, int l1, int r1, int l2, int r2) {
        int []tmpNums=new int[r2-l1+1];
        int index=r2-l1;
        int tmpR2=r2;
        while (l1<=r1 && l2<=r2){
            if(nums[r1]>=nums[r2]){
                tmpNums[index--]=nums[r1];
                r1--;
                cnt+=r2-l2+1;
            }else{
                tmpNums[index--]=nums[r2];
                r2--;
            }
        }
        while (l1<=r1){
            tmpNums[index--]=nums[r1];
            r1--;
        }
        while (l2<=r2){
            tmpNums[index--]=nums[r2];
            r2--;
        }

        for(int i=0;i<tmpNums.length;i++){
            nums[l1+i]=tmpNums[i];
        }
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int []nums={7,5,6,4};
        System.out.println(s.InversePairs(nums));
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]);
    }
}
