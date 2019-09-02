package solution_3;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * 小强写的
 */

public class LRU {
    //定义一个Node类
    class Node {
        int key;
        int value;
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return this.key + "-" + this.value + " ";
        }
    }

    //定义一个HashMap，用于存储数据
    private HashMap<Integer, Node> data = new HashMap<>();
    //容量
    private int capacity;
    //定义一个双向链表来管理Node
    private LinkedList<Node> link = new LinkedList<>();

    private LRU(int capacity) {
        this.capacity = capacity;
    }

    //get方法
    private int get(int key) {
        if (data.containsKey(key)) {
            Node node = data.get(key);
            link.remove(node);
            link.offerFirst(node);
            printNodes("执行get操作(" + key + ")");
            return node.value;
        }

        //不存在
        printNodes("执行get操作(" + key + ")");
        return -1;
    }

    //set方法
    private void set(int key, int value) {
        if (data.containsKey(key)) {
            //更新value
            Node node = data.get(key);
            node.value = value;
            link.remove(node);
            link.offerFirst(node);
        } else {
            Node node = new Node(key, value);
            if (data.size() < capacity) {
                //把这个结点移动到头部
                link.offerFirst(node);
            } else {
                //删除末尾结点
                Node tail = link.pollLast();
                if(tail != null){
                    data.remove(tail.key);
                    //把这个结点移动到头部
                    link.offerFirst(node);
                }
            }
            //插入到hashmap中
            data.put(key, node);
        }
        printNodes("执行set操作(" + key + "-" + value + ")");
    }

    //链表打印操作
    private void printNodes(String explain) {
        System.out.print(explain + "，此时链表为:");
        for(Node node : link){
            System.out.print(node.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRU cache = new LRU(2);

        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.set(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.set(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4

    }
}

