package solution_3;

/*import java.util.Scanner;
public class solution_30 {
    public static long func(long num) {
        long count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long tmp=in.nextLong();
        System.out.println(solution_30.func(tmp));
    }
}*/

/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class solution_30 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums=in.nextInt();
        String queryTime=in.next();
        ArrayList<Order> orders=new ArrayList<>();
        for(int i=0;i<nums;i++){
            Order o=new Order();
            o.id=in.nextLong();
            o.inTime=in.next();
            o.outTime=in.next();
            if((o.inTime.compareTo(queryTime)<=0)&&(o.outTime.compareTo(queryTime)>=0)){
                o.flag=true;
                orders.add(o);
            }
        }
        Collections.sort(orders);
        if(orders.size()==0){
            System.out.println("null");
            return;
        }
        for(int i=0;i<orders.size();i++){
            System.out.println(orders.get(i).id);
        }
    }
}
class Order implements  Comparable{
    long id;
    String inTime;
    String outTime;
    boolean flag=false;
    @Override
    public int compareTo(Object o) {
        Order order=(Order)o;
        if(id<order.id)
            return -1;
        else
            return 1;
    }
}*/

/*import java.util.HashMap;
import java.util.Scanner;

public class solution_30{
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head;
    private Node end;
    private int capacity;
    private int n;

    public solution_30(int capacity) {
        this.capacity = capacity;
        n = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;
        } else {
            return -1;
        }
    }

    public void removeNode(Node node) {
        Node cur = node;
        Node pre = cur.pre;
        Node post = cur.next;

        if (pre != null) {
            pre.next = post;
        } else {
            head = post;
        }

        if (post != null) {
            post.pre = pre;
        } else {
            end = pre;
        }
    }

    public void setHead(Node node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }

        head = node;
        if (end == null) {
            end = node;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            oldNode.val = value;
            removeNode(oldNode);
            setHead(oldNode);
        } else {
            Node newNode =
                    new Node(key, value);
            if (n < capacity) {
                setHead(newNode);
                map.put(key, newNode);
                n++;
            } else {
                map.remove(end.key);
                end = end.pre;
                if (end != null) {
                    end.next = null;
                }

                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nums=scanner.nextInt();
        String[] str=scanner.next().split(" ");
        solution_30 mainClass=new solution_30(nums);
        if(str[0].equals("p")){
            mainClass.set(Integer.parseInt(str[1]),Integer.parseInt(str[2]));
        }
        if(str[0].equals("g")){
            System.out.println(mainClass.get(Integer.parseInt(str[1])));
        }
    }
}



class Node {
    public int val;
    public int key;
    public Node pre;
    public Node next;

    public Node(int key, int value) {
        val = value;
        this.key = key;
    }
}*/

/*
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) {
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.addFirst("d");//头部插入
        System.out.printf("头部元素： %s \n",linkedList.getFirst());//得到头部元素
        System.out.printf("尾部元素： %s \n",linkedList.getLast());//得到尾部元素

        System.out.println("----------- 打印链表中的全部元素-----------");
        int n=linkedList.size();
        for(int i=0;i<n;i++){
            System.out.println(linkedList.get(i));
        }
        //移除指定位置的元素
        linkedList.remove(0);

        //在指定位置插入元素
        linkedList.add(0,"e");

        System.out.println("----------- 打印链表中的全部元素-----------");
        n=linkedList.size();
        for(int i=0;i<n;i++){
            System.out.println(linkedList.get(i));
        }
    }
}*/

/*
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static ArrayList<Integer>[] list;
    static boolean []visit;
    static int count=0;
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        list=new ArrayList[n+1];
        visit=new boolean[n+1];
        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<n-1;i++){
            int x,y;
            x=scanner.nextInt();
            y=scanner.nextInt();
            list[x].add(y);
            list[y].add(x);
            //System.out.printf("%d %d\n",x,y);
        }


        DFS(1,n);
        System.out.println(count);
    }



    public static void DFS(int u,int n){
        visit[u]=true;
        for(int i=1;i<list[u].size();i++){
            int v=list[u].get(i);
            if(visit[v]==false){
                System.out.printf("当前节点 :%d\n",v);
                count++;
                DFS(v,n);
                if(!isAllVisited(n,visit))
                    count++;
            }
        }
    }
    static boolean  isAllVisited(int n,boolean []visit){
        for(int i=1;i<=n;i++){
            if(visit[i]==false)
                return false;
        }
        return true;
    }
}*/

/*
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static int k=0;
    static int n
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        boolean[] visit=new boolean[n+1];
        int result=0;


    }
    class Node{
        int val;
        ArrayList<Integer> next;
        Node(){
            next=new ArrayList<Integer>();
        }
    }
    void dfs(boolean []vis,ArrayList<Node>s,int i,int res,int t){
        if(vis[i] == true)
        {
            return;
        }
        vis[i]=true;

        k=Math.max(k,t);
        if(s.get(i).next.size()==0)
        {
            res++;
            return;
        }
        if(s.get(i).next.size()==1)
        {

            res+=2;

            for(int j=0;j<s.get(i).next.size();j++)
            {

                dfs(vis,s,s.get(i).next.get(j),res,t+1);
            }

        }
        else
        {
            res+=2;
            for(int j=0;j<s.get(i).next.size();j++)
            {
                dfs(vis, s,s.get(i).next.get(i),res,t+1);
            }
        }

    }
}
*/

//第三题
/*
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int size=scanner.nextInt();
        int times=scanner.nextInt();
        int [] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }

        int [] maxTimes=new int[n];
        HashMap <Integer, Integer> myMap = new HashMap <>();

        for(int i=0;i<nums.length;i++){
            if(i<size){
                if(myMap.containsKey(nums[i])){
                    myMap.put(nums[i],myMap.get(nums[i])+1);
                }else{
                    myMap.put(nums[i],1);
                }
                maxTimes[i]=Math.max(maxTimes[i],myMap.get(nums[i]));
            }else{
                if(myMap.containsKey(nums[i])){
                    myMap.put(nums[i],myMap.get(nums[i])+1);
                }else{
                    myMap.put(nums[i],1);
                }
                myMap.put(nums[i-size],myMap.get(nums[i-size])-1);
                if(myMap.get(nums[i-size])+1==maxTimes[i-1]){
                    maxTimes[i]=maxTimes[i-1]-1;
                }else{
                    maxTimes[i]=maxTimes[i-1];
                }
            }
        }
        int count=0;
        for(int i=size-1;i<nums.length;i++){
            if(maxTimes[i]>=times){
                count++;
            }
        }
        System.out.println(count);
    }
}
*/
