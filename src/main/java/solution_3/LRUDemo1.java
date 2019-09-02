package solution_3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 自己手写的LRU，主要使用了LinkedList,为了实现快速查找某个key是否在LinkedList中，我额外使用了一个HashMap，以此来实现快速访问
 */
public class LRUDemo1 {
    private LinkedList<Node> list;//队首元素表示最久未使用的元素，队尾元素表示最近刚使用的元素
    private HashMap<Integer,Node> map;//使用map是为了快速访问，例如给定一个key，判断该node是否存在
    private int capacity;
    int size;
    LRUDemo1(int capacity){
        list=new LinkedList<>();
        map=new HashMap<>();
        this.capacity=capacity;
        this.size=0;
    }
    public void set(int key,int value){
        Node node=new Node(key,value);
        if(!map.containsKey(key)){//key在map中不存在
            if(size>=capacity){//链表已满
                map.remove(list.getFirst().key);//将队首元素从map中移除
                list.removeFirst();//将队首元素从队列中移除
                list.add(node);//将该元素从队尾插入
                map.put(key,node);

            }else{//链表未满，并且链表中不存在该元素
                map.put(key,node);
                list.add(node);
                size++;
            }

        }else{//key在map中存在
            map.put(key,node);
            list.remove(node);//根据key来判断是否相同，如果key相同就认为两个node相等
            list.add(node);//移除了key相同的node之后，我们再将新添的node加入进去
        }
    }

    public int get(int key){
       if(map.containsKey(key)){
           Node node=map.get(key);
           list.remove(node);
           list.add(node);
           return node.value;
       }else{
           return -1;
       }
    }

    public static void main(String[] args) {
        LRUDemo1 cache = new LRUDemo1(2);

        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.set(3, 3);    // 该操作会使得key 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.set(4, 4);    // 该操作会使得key 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
    class  Node{
        int key;
        int value;
        Node(int k,int v){
            key=k;
            value=v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {

            return Objects.hash(key);
        }
    }
}
