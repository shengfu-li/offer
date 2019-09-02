package solution_48;

import sun.java2d.pipe.SolidTextRenderer;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
    面试题48：最长不包含重复字符的子字符串。
    使用动态规划的思想，使用dp[i]表示以第i个字符结尾的不包含重复子串的字符串。
    要情况讨论，字符c之前是否出现过？  如果出现过，字符c是否在dp[i-1]的范围之内出现过？
    有个小技巧：我们使用preIndex来保存最近的一个字母'a'，例如preIndex[str[i]-'a']保存str[i]的最近位置。
*/
public class Solution {
    public int longestSubStringWithoutDuplication(String str) {
        int []dp=new int[str.length()];
        Arrays.fill(dp,0);
        //题目保证传进来的都是字母，例如使用一个数组来保存最近的一个字母'a'，例如preIndex[str[i]-'a']保存str[i]的最近位置。
        int []preIndex=new int[26];
        Arrays.fill(preIndex,-1);
        dp[0]=1;
        preIndex[str.charAt(0)-'a']=0;
        int len=str.length();
        int result=dp[0];//结果
        for(int i=1;i<len;i++){
            char c=str.charAt(i);
            if(preIndex[c-'a']==-1){//说明字符c之前没有出现过
                dp[i]=dp[i-1]+1;
            }else{//说明字符c之前出现过
                int distance=i-preIndex[c-'a'];
                if(distance<=dp[i-1]){//字符c在dp[i-1]的范围之内
                    dp[i]=distance;
                }else{//字符c在dp[i-1]的范围之外
                    dp[i]=dp[i-1]+1;
                }
            }
            preIndex[c-'a']=i;
            if(dp[i]>result){
                result=dp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        //int result=s.longestSubStringWithoutDuplication("arabcacfr");
        String str=new Scanner(System.in).nextLine();
        int result=s.longestSubStringWithoutDuplication(str);
        System.out.println(result);
    }
}
