package solution_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 有缺陷，remove操作没有实现，还有扩容之后的rehash操作也没有实现
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K,V> {
    //当前数组的容量
    private  int capacity;
    //当前数组中元素的个数
    private  int size;
    private LinkedList<Entry>[] array;
    public MyHashMap(int capacity){
        this.size=0;
        this.capacity=capacity;
        array=new LinkedList[capacity];
    }

    public void put(K key,V value){
        if(this.size>=capacity){

        }
        int index=key.hashCode()%capacity;
        Entry<K,V> entry=new Entry<>(key,value);
        if(array[index]==null){
            array[index]=new LinkedList<>();
            array[index].add(entry);
        }else {
            int i=0;
            for(i=0;i<array[index].size();i++){
                if(entry.equals(array[index].get(i))){
                    break;
                }
            }
            //key存在
            if(i<array[index].size()){
                array[index].get(i).value=value;
            }else{//key不存在
                array[index].add(new Entry<K,V>(key,value));
                this.size++;
            }
        }


    }

    public V get(K key){
        int index=key.hashCode()%capacity;
        Entry<K,V> entry=new Entry<>(key,null);
        int i=0;
        for(i=0;i<array[index].size();i++){
            if(entry.equals(array[index].get(i))){
                break;
            }
        }
        //key存在
        if(i<array[index].size()){
            return (V)array[index].get(i).value;
        }else{//key不存在
            return null;
        }

    }

    /*public void remove(K key){
        Entry<K,V> entry=array[key.hashCode()%capacity];
        if(entry!=null){
            array[key.hashCode()%capacity]=null;
        }

    }*/

    public void reHash(){

    }
    public static void main(String[] args) {
        MyHashMap<Integer,String> myHashMap=new MyHashMap(2);
        myHashMap.put(1,"shengfu");
        myHashMap.put(2,"li");
        myHashMap.put(2,"lili");
        myHashMap.put(3,"xiaoge");
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(3));

    }
    class Entry<K,V>{
        K key;
        V value;
        Entry(K key,V value){
            this.key=key;
            this.value=value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {

            return Objects.hash(key);
        }
    }

}
