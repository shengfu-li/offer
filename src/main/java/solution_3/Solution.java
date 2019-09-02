package solution_3;
/*
//面试题3：数组中的重复数字
import java.util.HashMap;
import java.util.Map;
public class solution_30 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        HashMap<Integer,Integer> myHash=new HashMap<Integer,Integer>();
        for(int i=0;i<length;i++){
            if(myHash.containsKey(numbers[i])){
                myHash.put(numbers[i],myHash.get(numbers[i])+1);
            }else{
                myHash.put(numbers[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:myHash.entrySet()){
            if(entry.getValue()>1){
                duplication[0]=entry.getKey();
                return true;
            }
        }
        return false;
    }
}*/

