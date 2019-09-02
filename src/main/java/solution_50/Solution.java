package solution_50;

/**
 * 面试题50：第一个只出现一次的字符
 * 注意我们申请了一个256大小的数组，而不是申请一个26大小或者52大小的数组。
 * 还有需要注意的是：因为'A'的ASCII码比‘a’小，所以我们要这样hash[c-'A']++;，而不能hash[c-'a']++;，
 * 或者我们直接这样也行：hash[c-]++;
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int result=-1;
        int [] hash=new int[256];
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            //hash[c-'A']++;
            hash[c]++;
        }
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            //if(hash[c-'A']==1){
            if(hash[c]==1){
                result=i;
                break;
            }
        }
        return result;
    }
}