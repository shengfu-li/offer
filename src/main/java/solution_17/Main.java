package solution_17;

/**
 * 打印从1到最大的n位数
 * 我们可以使用两种方式：第一种就是自己使用字符串模拟，第二种就是使用全排列。两种我们都要尝试下！
 *
 */


/**
 * 先是第一种：自己手动模拟字符串加法，从个位数开始。（先做好+1操作，如果一直加下去的话，什么时候截止呢？我们需要一个溢出标志位）
 */
public class Main{
    public static void main(String[] args) {
        //打印从1到最大的n位数
        int n=3;
        char [] nums=new char[n];
        for(int i=0;i<n;i++)
            nums[i]='0';
        //print1ToMaxNDigit(nums);
        while(!increment(nums)){
            printNums(nums);
        }
    }
    static boolean increment(char[] nums){
        if(nums.length==0) return true;

        int len=nums.length;
        boolean isOverFlow=false;
        int token=0;
        int sum=0;
        for(int i=len-1;i>=0;i--){
            sum=nums[i]-'0'+token;
            token=0;
            if(i==len-1)
                sum++;
            if(sum<10){
                nums[i]=(char)(sum+'0');
                break;
            }else{
                token=1;
                nums[i]='0';
            }
            if(token==1&&i==0){
                isOverFlow=true;
                break;
            }
        }


        return isOverFlow;
    }
    public static void printNums(char []nums){
        int index;
        for(index=0;index<nums.length;index++)
            if(nums[index]!='0')
                break;
        for(int i=index;i<nums.length;i++)
            System.out.print(nums[i]);
        System.out.println();
    }
}

/**
 * 2、然后是第二种：输出n位数可以看成n个数的全排列，我们可以使用递归来输出全排列
 */
/*
public class Main {
    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private static void print1ToMaxOfNDigits(char[] number, int depth) {
        if (depth == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[depth] = (char) (i + '0');
            print1ToMaxOfNDigits(number, depth + 1);
        }
    }

    private static void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }
}


*/