package solution_49;

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        //加上下面这条句是为了防止index数组的长度太小，例如index=0，那么我下面的result[1]=2;就会报数组越界异常了！
        if(index<6)
            return index;
        int []result=new int[index];
        int cnt=0;
        result[0]=1;
        result[1]=2;
        result[2]=3;
        result[3]=4;
        result[4]=5;
        cnt=5;
        while(cnt<index){
            int m2=0,m3=0,m5=0;
            for(int i=0;i<cnt;i++){
                m2=result[i]*2;
                if(m2>result[cnt-1]){
                    break;
                }
            }
            System.out.printf("m2: %d\n",m2);
            for(int i=0;i<cnt;i++){
                m3=result[i]*3;
                if(m3>result[cnt-1]){
                    break;
                }
            }
            System.out.printf("m2: %d\n",m2);
            for(int i=0;i<cnt;i++){
                m5=result[i]*5;
                if(m5>result[cnt-1]){
                    break;
                }
            }
            System.out.printf("m2: %d\n",m2);
            result[cnt]=Math.min(Math.min(m2,m3),m5);
            cnt++;
        }
        return result[index-1];
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.GetUglyNumber_Solution(6));
    }
}