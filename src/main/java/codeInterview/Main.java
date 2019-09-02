
package codeInterview;

/*import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sum;
        Scanner scanner=new Scanner(System.in);
        sum=scanner.nextInt();
        int [] nums=new int[sum];
        for(int i=1;i<nums.length;i++)
            nums[i]=i;

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<nums.length;i++)
            cal(nums,sum,i,1,list);
    }
    public  static  void cal(int []nums,int sum,int index,int depth,ArrayList<Integer> list){
        System.out.printf("当前sum ：%d\n",sum);
        for(Integer e:list)
            System.out.printf("%d ",e);
        System.out.println();
        if(index>=nums.length) return;
        if(sum<0) return;
        else if(sum==0){
            for(Integer e:list)
                System.out.printf("%d ",e);
            System.out.println();

            return;
        }

        list.add(nums[index]);
        for(int i=index;i<nums.length;i++){
            cal(nums,sum-nums[i],i+1,depth+1,list);
        }
        int len=list.size();
        list.remove(len-1);
    }
}
*/

/*
import java.util.Scanner;

//网易笔试第一题
public class Main{
    public static void main(String[] args) {
        String str=new String();
        Scanner scanner=new Scanner(System.in);
        str=scanner.nextLine();
        int []dp=new int[str.length()];
        dp[0]=1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=dp[i-1];
            }
        }
        System.out.println(dp[str.length()-1]);
    }
}*/

/*
import java.util.Scanner;

//第二题
public class Main{
    public static void main(String[] args) {
        int t;
        Scanner scanner=new Scanner(System.in);
        t=scanner.nextInt();
        while(t--!=0){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            //最少住人数
            System.out.printf("%d ",0);
            for(int i=0;i<k-1;k++)
        }
    }
}*/


/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        long n,k;
        long minNum=0,maxNum;
        long[] result=new long[t];
        for(int i=0;i<t;i++){
            n=scanner.nextLong();
            k=scanner.nextLong();
            if(n<=2){
                maxNum=0;
            }else{
                long temp=k-1;;
                if((n-k)>temp){
                    maxNum=temp;
                }else{
                    maxNum=n-k;
                }
            }
            result[i]=maxNum;
        }
        for(int i=0;i<t;i++){
            System.out.println(minNum+" "+result[i]);
        }


    }

}
*/

/*
//网易第二题：房子 ac
import java.util.Scanner;

public class Main {

    public static int getMaxValue(int[] house){
        int n = house[0];
        int k = house[1];
        int max = 0;
        if(n == k || k < 2) return 0;
        if(k < n /2 )
            return k-1;
        else
            return n-k;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[][] house =new int[t][2];
        for(int i = 0;i <t ;i++){
            house[i][0] = in.nextInt();
            house[i][1] = in.nextInt();
        }
        int minVal,maxVal;
        for(int n =0; n < t;n++){
            minVal = 0;
            maxVal = getMaxValue(house[n]);
            System.out.println(minVal + " " + maxVal);
        }
    }

}

*/


/*
//网易第一题：斑马橡皮泥修改 通过18%
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.next();
        int [] dp=new int[str.length()];
        dp[0]=1;
        int maxVal=dp[0];
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=dp[i-1];
            }
            maxVal=Math.max(maxVal,dp[i]);
        }
        if(maxVal!=str.length()){
            for(int i=0;i<str.length()-1;i++){
                if(str.charAt(i)==str.charAt(i+1)){
                    if(str.charAt(0)!=str.charAt(str.length()-1)){
                        maxVal=Math.max(maxVal,dp[i]+dp[str.length()-1]);
                    }else{
                        maxVal=Math.max(maxVal,Math.max(dp[i],dp[str.length()-1]));
                    }
                }
            }
        }
        System.out.println(maxVal);
    }
}
*/




/*
//网易第一题：斑马橡皮泥AC代码，滑动窗口法，无论反转几次形成的字符串都是s+s的子串或逆序子串，只需在s+s中查找最长连续反转子串长度(不超过n)即可；时间复杂度O(n)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.next();
        int m = str.length();
        int [] flag=new int[200000];//flag[i]==1表示，flag[i]=!flag[i+1]，当前位置字符与下一位置字符不一致
        for(int i=0;i<m;i++) {
            if(str.charAt(i)!=str.charAt((i+1)%m)==true)
                flag[i]=1;
            else
                flag[i]=0;
        }
        int sum = 1,result = 1;
        for(int i=0;i<2*m;i++) {
            int tmp=i%m;
            if(flag[tmp]==0) sum = 1;
            else {
                sum++;
                result = Math.max(result,sum);
            }
        }
        if(result>=m)
            result = m;

        System.out.println(result);
    }
}

*/



/*
//京东笔试第一题：多部图,代码有缺陷

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int n,m;
        while(T-- > 0){
            n = scan.nextInt();
            m = scan.nextInt();
            int[][] graph = new int[n+1][n+1];
            int a,b;
            for(int i=0;i<m;i++){
                a = scan.nextInt();
                b = scan.nextInt();
                graph[a][b] = graph[b][a] =1;
            }

            Set<Integer> original = new HashSet<>();
            for(int i=1;i<=n;i++) original.add(i);
            Set<Integer> collection = new HashSet<>();
            for(int i=1;i<=n;i++){
                for(int j=i;j<=n;j++){
                    if(j==i) continue;
                    if(graph[i][j] == 0){
                        boolean tmp = false;
                        for(int k:collection){
                            if(graph[k][j] == 1 ) {
                                tmp = true;
                                break;
                            }
                        }
                        if(!tmp){
                            collection.add(i);
                            collection.add(j);
                            original.remove(i);
                            original.remove(j);
                        }
                    }
                }
            }
            if(collection.size() == n){
                System.out.println("Yes");
                continue;
            }
            boolean flag = false;
            for(int i:collection){
                for(int j:original){
                    if(graph[i][j]==0){
                        System.out.println("No");
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            if(!flag) System.out.println("Yes");
        }
    }
}
*/

/*
//京东笔试第二题：（下面代码不用看）直接爆搜就能通过
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //给定n个物品，判断是否满足合格要求
        //思路:对给定商品进行排序，之后标记每次满足大于要求的游标index

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int [][] nums=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                nums[i][j]=sc.nextInt();
            }
        }

        //自定义比较器
        Comparator <int[]> comparator = new Comparator <int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return 1;
                }else if(o1[0]==o2[0]){
                    if(o1[1]>o2[1]){
                        return 1;
                    }else if(o1[1]==o2[1]){
                        return o1[2]-o2[2];
                    }else{
                        return -1;
                    }
                }else
                    return -1;
            }
        };
        if(nums.length==1){
            System.out.println(0);
        }else{
            Arrays.sort(nums,comparator);
            int nextIndex=1;
            int count=0;
            int len=nums.length;
            for(int i=0;i<nums.length;i++){
                if(myBinarySearch(nums,nums[i])!=len){
                    count++;
                    break;
                }
            }
            System.out.println(count);
        }
    }
    static int myBinarySearch(int [][]nums,int []key){
        int len=nums.length;
        if(nums[len-1][0]<key[0]&&nums[len-1][1]<key[1]&&nums[len-1][2]<key[2]) return len;
        int left=0,right=len-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid][0]>key[0]&&nums[mid][1]>key[1]&&nums[mid][1]>key[1]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    boolean myCompare(int [] num1, int []num2){
        if()
    }
}
*/


//亚信
/*
public class Main{
    public static void main(String[] args) throws Exception {
        //System.out.println(bitOfFactorial(4));
        int []rates={400,300,500,300,250};
        System.out.println(exchangeRate(rates));
    }
    public static int bitOfFactorial(int n) throws Exception{
        double result=Math.log10(2*Math.PI*n)/2;
        result+=n*Math.log10(n/Math.E)+1;
        return (int)result;


    }
    public static double exchangeRate(int[] rates) throws Exception{
        double res=1.0;
        boolean flag=true;//true表示要买入
        for(int i=0;i<rates.length;i++){
            if(i+1<rates.length && rates[i]>rates[i+1] && flag){//要买入
                res*=rates[i];
                flag=false;
            }
            if(i+1<rates.length && rates[i]<rates[i+1] && !flag){//要卖出
                res/=rates[i];
                flag=true;
            }

        }
        if(!flag)
            res/=rates[rates.length-1];
        return res*100;
    }
}

*/




//iqiyi 编程题1
/*
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int leftSum= str.charAt(0)-'0'+str.charAt(1)-'0'+str.charAt(2)-'0';
        int rightSum= str.charAt(3)-'0'+str.charAt(4)-'0'+str.charAt(5)-'0';
        if(leftSum==rightSum) System.out.println(0);
        else if(leftSum<rightSum){
            int [] arr={str.charAt(0)-'0',str.charAt(1)-'0',str.charAt(2)-'0'};
            Arrays.sort(arr);
            int min=arr[0];
            int mid=arr[1];
            int max=arr[2];
            int range1=9+mid+max;
            int range2=9+9+max;
            int range3=9+9+9;
            if(rightSum>=1 && rightSum<=range1 )
                System.out.println(1);
            else if(rightSum>= range1+1 && rightSum<=range2)
                System.out.println(2);
            else
                System.out.println(3);
        }else{
            int swapVal=leftSum;
            leftSum=rightSum;
            rightSum=swapVal;

            int [] arr={str.charAt(3)-'0',str.charAt(4)-'0',str.charAt(5)-'0'};
            Arrays.sort(arr);
            int min=arr[0];
            int mid=arr[1];
            int max=arr[2];
            int range1=9+mid+max;
            int range2=9+9+max;
            if(rightSum>=1 && rightSum<=range1 )
                System.out.println(1);
            else if(rightSum>= range1+1 && rightSum<=range2)
                System.out.println(2);
            else
                System.out.println(3);
        }

    }
}
*/


//iqiyi编程题2
/*
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,m,p;
        n = scanner.nextInt();
        m = scanner.nextInt();
        p = scanner.nextInt();

        Food[] foods = new Food[n];
        for(int i=0;i<n;i++){
            int t = scanner.nextInt();
            foods[i] = new Food(i+1,t);
        }
        scanner.nextLine();
        for(int i=0;i<m;i++){
            String str = scanner.nextLine();
            String strs[] = str.split(" ");
            int no = Integer.parseInt(strs[1]);
            if(strs[0].equals("A")){
                foods[no-1].num++;
            }else if(strs[0].equals("B")){
                if(foods[no-1].num>0) foods[no-1].num--;
            }
        }
        Arrays.sort(foods);
        int rank=1,tmp=1;
        Food t = null;
        for(Food f:foods){
            if(t == null){
                t = f;
            }else if(t.num != f.num){
                rank = tmp;
                t = f;
            }

            if(p==f.id){
                System.out.println(rank);
                break;
            }

            tmp++;
        }
    }

}
class Food implements  Comparable{
    int id;
    int num;
    public Food(int id,int num){
        this.id = id;
        this.num = num;
    }

    @Override
    public int compareTo(Object o) {
        Food food=(Food)o;
        if(this.num>this.num) return -1;
        else if(this.num<this.num) return 1;
        return 0;
    }

}*/


//iqiyi编程题2
/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n,m,p;
        n = scan.nextInt();
        m = scan.nextInt();
        p = scan.nextInt();

        Food[] foods = new Food[n];
        for(int i=0;i<n;i++){
            int tmp = scan.nextInt();
            foods[i] = new Food(i+1,tmp);
        }
        scan.nextLine();

        for(int i=0;i<m;i++){
            String string = scan.nextLine();
            String strings[] = string.split(" ");
            int id = Integer.parseInt(strings[1]);
            if(strings[0].equals("B")){
                if(foods[id-1].num>0) foods[id-1].num--;
            }else if(strings[0].equals("A")){
                foods[id-1].num++;
            }
        }

        Arrays.sort(foods);
        int tmpVal=1,rank=1;
        Food tmpFood = null;
        for(Food f:foods){
            if(tmpFood == null){
                tmpFood = f;
            }else if(tmpFood.num != f.num){
                rank = tmpVal;
                tmpFood = f;
            }
            tmpVal++;
            if(f.id==p){
                System.out.println(rank);
                break;
            }
        }
    }

}
class Food implements  Comparable{
    int id;
    int num;
    public Food(int id,int num){
        this.id = id;
        this.num = num;
    }
    @Override
    public int compareTo(Object o) {
        Food food=(Food)o;
        if(this.num>food.num) return -1;
        else if(this.num<food.num) return 1;
        return 0;
    }
}
*/





//换牛奶和的题目，牛奶5块钱一瓶，4个瓶盖换一个牛奶，3个空瓶也换一个牛奶
/*
class Drink{

    int totalNum = 0;
    int leftPingZi = 0, leftGaiZi = 0;

    public void calCum(int money){
        int currentNum = money / 5;
        totalNum += currentNum;
        int currentLeftPingZi = leftPingZi + currentNum;
        int currentLeftGaiZi = leftGaiZi + currentNum;

        int leftMoney = 0;
        if (currentLeftPingZi >= 3) {
            int pzMoney = (currentLeftPingZi / 3) * 5;
            leftMoney += pzMoney;
            leftPingZi = currentLeftPingZi - (pzMoney / 5) * 3;
        } else {
            leftPingZi = currentLeftPingZi;
        }
        if (currentLeftGaiZi > 3) {
            int gzMoney = (currentLeftGaiZi / 4) * 5;
            leftMoney += gzMoney;
            leftGaiZi = currentLeftGaiZi - (gzMoney / 5) * 4;

        } else {
            leftGaiZi = currentLeftGaiZi;
        }
        if (leftMoney >= 5) {
            calCum(leftMoney);
        }
    }

    public int drinkMilk(int money){
        int drunkMilk = 0;

        calCum(money);
        drunkMilk = totalNum;

        return drunkMilk;
    }
}
*/


/*import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,m;
        n=scanner.nextInt();
        m=scanner.nextInt();
        scanner.nextLine();
        HashMap<Integer,Node> myHash=new HashMap<>();
        int [][]graph=new int [1010][1010];
        for(int i=0;i<m;i++){
           int n1,n2;
           n1=scanner.nextInt();
           n2=scanner.nextInt();
           graph[n1][n2]=1;
            //System.out.printf("%d %d\n",n1,n2);

        }
        ArrayList<Integer> list=new ArrayList<>();
        HashSet<Integer> myset=new HashSet<>();
        for(int i=1;i<=n;i++){
            dfs(i,n,graph,myset,myHash,list);
        }
        int count=0;
        for(Map.Entry entry:myHash.entrySet()){
            Node node =(Node)entry.getValue();
            if(node.inputDegree>node.outputDegree)
                count++;
            System.out.printf("node %d,input:%d output:%d\n",entry.getKey(),node.inputDegree,node.outputDegree);
        }
        System.out.println(count);
    }
    static void dfs(int index,int n,int [][]graph,HashSet<Integer> myset,HashMap<Integer,Node> myHash,ArrayList<Integer> list){

        myset.add(index);//一次dfs时，该节点被访问过
        boolean flag=true;
        for(int i=1;i<=n;i++){
            if(graph[index][i]!=0 && !myset.contains(i)){//i没有被访问过
                flag=false;
                *//*if(!myHash.containsKey(index)){//当前点的出度要加一
                    Node node=new Node();
                    node.outputDegree=1;
                    myHash.put(index,node);
                }else{
                    Node node=myHash.get(index);
                    node.outputDegree+=1;
                    myHash.put(index,node);
                }*//*

                if(!myHash.containsKey(i)){//将访问过的节点的入度加一
                    Node node=new Node();
                    node.inputDegree=1;
                    myHash.put(i,node);

                }else{
                    Node node=myHash.get(i);
                    node.inputDegree+=1;
                    myHash.put(i,node);
                }

                list.add(index);
                dfs(i,n,graph,myset,myHash,list);
                list.remove(list.size()-1);
            }
        }
        if()
        myset.remove(index);
    }
}
class Node{
    int outputDegree=0;
    int inputDegree=0;

}*/


/*import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        long tmpVal1 = 1,tmpVal2 =1;
        long i;

        for(i=1;i<=n;i++) tmpVal1 = lcm(tmpVal1,i);

        while(true){
            tmpVal2 = lcm(tmpVal2,i);
            if(i>n &&tmpVal2 % tmpVal1 == 0 ){
                System.out.println(i);
                break;
            }
            i++;
        }
    }
    static long lcm(long a, long b) {
        return (a*b) / fun1(a,b);
    }
    static long fun1(long a, long b) {
        return b==0 ? a: fun1(b,a % b);
    }

}*/

/*
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        String[] strings;
        HashMap<String,Integer> hash=new HashMap<>();//存放例如 15出现的次数，例如15出现了3次
        HashMap<String,ArrayList<String>> hash2=new HashMap<>();//存放例如 15对应的输入，例如15-> 10#15
        do{
            str=scanner.next();
            strings=str.split("#");
            if(str.equals("END")) break;
            int radix=Integer.valueOf(strings[0]);
            String value=Integer.valueOf(strings[1],radix).toString();
            if(!hash.containsKey(value)){
                hash.put(value,1);
            }else{
                hash.put(value,hash.get(value)+1);
            }
            if(!hash2.containsKey(value)){
                ArrayList<String> list=new ArrayList<>();
                list.add(str);
                hash2.put(value,list);
            }else{
                hash2.get(value).add(str);
            }


        }while (!str.equals("END"));

        int minNum=Integer.MAX_VALUE;
        String result=new String();
        if(hash.size()<=1)
            System.out.println("None");
        else{
            for(Map.Entry<String,Integer> v:hash.entrySet()){
                if(minNum>v.getValue()){
                    result=v.getKey();
                    minNum=v.getValue();
                }
            }
        }
        //System.out.println(result+"____________");
        for(String s:hash2.get(result)){
            System.out.println(s);
        }
    }
}

//


*/

/*
//B站扭蛋机，AC
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int result=scanner.nextInt();
        Stack<Integer> myStack=new Stack<>();
        while (result!=0){
            if((result& 0x01 )!=1){//说明是result偶数
                result=(result-2)/2;
                myStack.push(3);
            }else{
                result=(result-1)/2;
                myStack.push(2);
            }
        }
        while (!myStack.isEmpty()){
            System.out.print(myStack.pop());
        }
    }
}*/

import org.omg.CORBA.Current;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("hello");
        stringBuilder.append("world");


    }
}

