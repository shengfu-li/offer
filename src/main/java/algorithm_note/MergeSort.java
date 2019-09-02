package algorithm_note;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * 归并排序可以分为递归和非递归两种，我们两种都要实现。不管是递归版本，还是非递归版本。核心都是merge()函数!!
 * 1）在递归版本中，最重要的就是合并函数merge的设计与实现。
 * 2）在非递归版本中，注意啊！求mid千万不能像下面这样求mid=(left+right)/2;
 * 因为假设num长度为7，所以step长度为4时，左半数组为可能为12,66,33,57，右半数组为27,64,18,此时如果我们mid=(left+right)/2，那么会将57划到右半数组中去！！！
 * 还有一个需要注意的：最后一步step的长度是要超过数组长度的！！！
 */



public class MergeSort {
    //下面是递归实现的版本
    /*
    public void mergeSort(int [] num,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(num,left,mid);
            mergeSort(num,mid+1,right);
            merge(num,left,mid,mid+1,right);
        }
    }*/

    //下面是非递归实现的版本
    public void mergeSort(int [] num){
        int n=num.length;
        //for(int step=2;step<num.length;step*=2){
        for(int step=2;step/2<=n;step*=2){
            for(int i=0;i<num.length;i=i+step){
                int left=i;
                int right=Math.min(i+step-1,num.length-1);
                //注意啊！求mid千万不能像下面这样求mid=(left+right)/2;
                //因为假设num长度为7，所以step长度为4时，左半数组为可能为12,66,33,57，右半数组为27,64,18,此时如果我们mid=(left+right)/2，那么会将57划到右半数组中去！！！
                //int mid=(left+right)/2;
                int mid=i+step/2-1;
                System.out.printf("left=%d,step=%d,right=%d,mid(i+step/2-1)=%d\n",left,step,right,i+step/2-1);
                System.out.printf("left=%d,step=%d,right=%d,mid(left+right)/2=%d\n\n",left,step,right,(left+right)/2);
                if(mid+1<=right)
                    merge(num,left,mid,mid+1,right);

            }
        }
    }

    public void merge(int []num,int l1,int r1,int l2,int r2){
        int []tmpNum=new int[r2-l1+1];
        int tmpNumIndex=0;
        int tmpL1=l1;
        while(l1<=r1 && l2<=r2){
            if(num[l1]<=num[l2]){
                tmpNum[tmpNumIndex++]=num[l1];
                l1++;
            }else{
                tmpNum[tmpNumIndex++]=num[l2];
                l2++;
            }
        }
        while (l1<=r1){
            tmpNum[tmpNumIndex++]=num[l1];
            l1++;
        }
        while (l2<=r2){
            tmpNum[tmpNumIndex++]=num[l2];
            l2++;
        }
        for(int i=0;i<tmpNumIndex;i++){
            num[i+tmpL1]=tmpNum[i];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
        int []num=new int[20];
        for(int i=0;i<num.length;i++)
            num[i]=num.length-i;
        //递归版本的mergeSort
        //mergeSort.mergeSort(num,0,num.length-1);
        //非递归版本的mergeSort
        mergeSort.mergeSort(num);
        for(int i=0;i<num.length;i++)
            System.out.println(num[i]);

        //<String,String> hash=new Hashtable<String,String>();
        //hash.put(null,null);
    }
}




