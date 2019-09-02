package solution_56;

/*
面试题56.1：数组中只出现一次的两个数字
可以通过使用异或来解决。我们知道1个数出现两次的话，这两个数的异或为0，例如 6^6=0.所以我们可以先将所有数组元素做异或，得到一个结果result,
从个位数开始寻找第一个1出现的位置，并且以此为标准，将数组分为左半数组和右半数组，我们所要找的这两个必定一个分布在左半数组，一个分布在右半数组！最后对这两个半数组做异或即可求出最终的结果！
*/

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int result=0;
        for(int i=0;i<array.length;i++){
            result^=array[i];
        }

        int tmpVal=1;
        while(tmpVal>0){
            if((tmpVal&result)>0){
                break;
            }else{
                tmpVal=tmpVal<<1;
            }
        }

        int result1=0;
        int result2=0;
        for(int i=0;i<array.length;i++){
            if((array[i]&tmpVal)>0)
                result1^=array[i];
            else
                result2^=array[i];
        }
        num1[0]=result1;
        num2[0]=result2;
    }
}