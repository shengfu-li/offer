package solution_38;
/**
 * 面试题38：字符串的排列！使用一个myHash记录下每个元素是否被访问过。注意：由于输入的元素可能会有重复，所以我们需要将结果去重！再一个使用myHash去重即可。
 */

import java.util.*;
public class Solution {
    int [] myHash=new int[26];
    ArrayList<String> list=new ArrayList();
    HashSet<String> mySet=new HashSet();//把结果放在里面去重！
    public ArrayList<String> Permutation(String str) {
        if(str.length()==0||str==null) return new ArrayList<String>();
        int len=str.length();
        for(int i=0;i<len;i++){
            myHash[str.charAt(i)-'a']++;
        }
        travel(myHash,str,0,new StringBuilder());
        return list;
    }
    void travel(int [] myHash,String str,int depth,StringBuilder builder){
        if(depth>=str.length()){
            if(!mySet.contains(new String(builder))){
                mySet.add(new String(builder));
                list.add(new String(builder));
            }

            return;

        }
        for(int i=0;i<str.length();i++){
            if(myHash[str.charAt(i)-'a']>0){
                myHash[str.charAt(i)-'a']--;
                builder.append(str.charAt(i));
                travel(myHash,str,depth+1,builder);
                builder.deleteCharAt(builder.length()-1);
                myHash[str.charAt(i)-'a']++;
            }
        }

    }
}