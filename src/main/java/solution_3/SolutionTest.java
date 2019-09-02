package solution_3;


import java.util.*;

public class SolutionTest {
    public static void main(String[] args) {
        PriorityQueue<Node> priorityQueue=new PriorityQueue<>();
        priorityQueue.offer(new Node("li",23));
        priorityQueue.offer(new Node("shengfu",24));
        priorityQueue.offer(new Node("li",22));
        int len=priorityQueue.size();
        for(int i=0;i<len;i++){
            Node n=priorityQueue.poll();
            System.out.printf("%s %d \n",n.name,n.age);
        }
    }
}
class Node implements Comparable{
    String name;
    int age;
    public  Node(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public int compareTo(Object o) {
        Node n=(Node)o;
        if(this.age<n.age){
            return -1;
        }else
            return 1;
    }
}
