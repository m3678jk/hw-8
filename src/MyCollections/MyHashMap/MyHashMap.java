package MyCollections.MyHashMap;

import java.util.*;

public class MyHashMap <K,V> {
    MyHashMap.MyNode<K, V> last;
    MyHashMap.MyNode<K, V> first;

    private int size = 0;

    private static class MyNode<K, V> {
        int hash;
        private final K key;
        private final V value;
        MyHashMap.MyNode<K, V> next;

        MyNode(K key, V value, MyHashMap.MyNode<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public final boolean equals(Object o) {
            if (o == null) {
                return false;
            }

            if (!(o instanceof MyNode)) {
                return false;
            }
            MyNode<K, V> another = (MyNode<K, V>) o;
            int hashOfO = o.hashCode();
            int hashAnother = another.hashCode();
            return hashOfO == hashAnother;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (MyHashMap.MyNode<K, V> x = first; x != null; x = x.next) {
            s += x + " ";
        }
        return "MyHashMap {" + s + "}";
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void put(K key, V value) {
         if (!isKeyInHashMap(key)) {
            MyHashMap.MyNode<K, V> l = last;
            MyHashMap.MyNode<K, V> f = first;
            final MyHashMap.MyNode<K, V> newNode = new MyHashMap.MyNode<K, V>(key, value, null, hashCode());
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            last = newNode;
            size++;
            System.out.println("Key - "+ key + " and value - " + value + " are added");

        } else {

             System.out.println("Key - " + key + " is alredy exsist.");
         }
    }
    public boolean isKeyInHashMap(K key){
        int count = 0;
        for (MyNode<K, V> y = first; y != null; y = y.next){
            if (key.equals(y.key)){
                count++;
            }

        }
        return count==1;
    }


    public void remove(K key) {
        size--;
        MyNode<K, V> nodeToRemove;
        int index = -1;
        for (MyNode<K, V> y = first; y != null; y = y.next) {
            index++;

            if (key.equals(y.key)) {
                nodeToRemove = y;
                MyNode<K, V> pointerForNextNode;
                pointerForNextNode = nodeToRemove.next;

                if (index >= 0 && index < size) {
                    MyHashMap.MyNode<K, V> z = first;

                    if (index == 0){
                        first = z.next;
                    } else {
                        for (int i = 0; i < index - 1; i++) {
                            z = z.next;
                        }
                        z.next = pointerForNextNode;
                    }
                }
            }
        }
    }

    public void clear(){
       first = null;
        setSize(0);
    }

    public int size(){
        return getSize();
    }

    public V get(K key) {
        int hashOfGivenKey = key.hashCode();

        MyNode<K,V> x;
            for ( x = first; x != null; x = x.next ) {
                if (key.equals(x.key)) {
                   return x.value;
                }
            }
        return null;
    }
}


class MyHashMapTest{
    public static void main(String[] args) {
        MyHashMap <String,String>  testedHashMap = new MyHashMap<String,String>();
        testedHashMap.put("Key1", "value1");
        System.out.println(testedHashMap);
        System.out.println("Size of testedHashMap - " + testedHashMap.getSize());
        testedHashMap.put("Key2", "value2");
        System.out.println(testedHashMap);
        testedHashMap.put("Key2", "value2");
        System.out.println(testedHashMap);
        System.out.println("Size of testedHashMap - " + testedHashMap.getSize());
        testedHashMap.put("Key3", "value3");
        System.out.println(testedHashMap);
        System.out.println("Size of testedHashMap - " + testedHashMap.getSize());
        testedHashMap.put("Key4", "value4");
        System.out.println(testedHashMap);
        System.out.println("Size of testedHashMap - " + testedHashMap.getSize());
        testedHashMap.put("Key5", "value5");
        System.out.println(testedHashMap);
        System.out.println("Size of testedHashMap - " + testedHashMap.getSize());
        testedHashMap.put("Key6", "value6");
        System.out.println(testedHashMap);
        System.out.println("Size of testedHashMap - " + testedHashMap.getSize());

        System.out.println("For Key1 value is -  " + testedHashMap.get("Key1"));
        System.out.println("For Key5 value is -  " + testedHashMap.get("Key5"));

        testedHashMap.remove("Key3");
        System.out.println("TestedHashMap after removing Key3 - " + testedHashMap);

        testedHashMap.remove("Key1");
        System.out.println("TestedHashMap after removing Key1 - " + testedHashMap);

        System.out.println("TestedHashMap size is - " + testedHashMap.size());

        testedHashMap.clear();
        System.out.println("TestedHashMap after clearing - " + testedHashMap);
        System.out.println("TestedHashMap size is - " + testedHashMap.size());

    }

}
