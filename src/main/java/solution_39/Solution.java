package solution_39;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0) return 0;
        if(array.length==1) return array[0];
        int k=array.length/2;
        int result=partition(array,0,array.length-1,k);
        int times=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==result) times++;
        }
        if(times>k) return result;
        else return 0;
    }
    int partition(int []array,int first,int last,int k){
        if(first<0||first>=array.length||last<0||last>=array.length ||first>=last ||k<0||k>=array.length) {
            return 0;
        }
        int tmp=array[first];
        int firstIndex=first,lastIndex=last;
        while(firstIndex<lastIndex){
            while(firstIndex<lastIndex && array[lastIndex]>tmp) lastIndex--;
            array[firstIndex]=array[lastIndex];
            while(firstIndex<lastIndex && array[firstIndex]<=tmp) firstIndex++;
            array[lastIndex]=array[firstIndex];
        }
        array[firstIndex]=tmp;
        int leftNum=firstIndex-first+1;
        if(k==leftNum) return tmp;
        else if(k<leftNum) return partition(array,first,firstIndex-1,k);//划分子问题的时候一定要注意将firstIndex排除出去！
        else return partition(array,firstIndex+1,last,k-leftNum);//划分子问题的时候一定要注意将firstIndex排除出去！
    }

    /*public static void main(String[] args) {

        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2)
                    return 1;
                else
                    return -1;
            }
        });
        for(int i=0;i<9;i++)
            queue.offer(i);
        for(int i=0;i<9;i++)
            System.out.printf("%d ",queue.poll());
    }*/

}