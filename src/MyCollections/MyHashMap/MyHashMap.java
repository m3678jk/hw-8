package MyCollections.MyHashMap;

import java.util.Objects;

public class MyHashMap<K, V> {
    private final static int TABLE_CAPACITY = 16;

    private final MyHashMap.MyNode<K, V>[] table = new MyHashMap.MyNode[TABLE_CAPACITY];

    private int size = 0;

    int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int indexForNewNode(int hash, int length) {
        return (length - 1) & hash;
    }


    public void put(K key, V value) {

        int index = indexForNewNode(hash(key), table.length);

        MyHashMap.MyNode<K, V> newNode = new MyHashMap.MyNode<>(hash(key), key, value, null);

        MyHashMap.MyNode<K, V> p;
        //if there is no node at counted index > create new node
        if ((p = table[index]) == null) {
            table[index] = newNode;
            size++;
        }
        //check if key is unique
        else {
            K k;
            if (p.hash == hash(key) && ((k = p.key) == key || (key != null && key.equals(k)))) {
                p.setValue(newNode.value);
            } else {
                while (p.next != null) {
                    p = p.next;
                }
                p.next = newNode;
                size++;

            }
        }
    }


    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
            size = 0;
        }
    }


    public void remove(K key) {
        int index = indexForNewNode(hash(key), table.length);
        MyHashMap.MyNode<K, V> nodeToRemove;

        if ((nodeToRemove = table[index]) != null) {
            if (nodeToRemove.next == null) {
                table[index] = null;

            } else {
                while (nodeToRemove.next != null) {
                    if (hash(nodeToRemove.getKey()) == hash(key)) {
                        continue;
                    }
                    table[index] = nodeToRemove.next;
                }
            }
            size--;
        }
    }


    public int size() {
        return size;
    }


    public V get(K key) {
        int index = indexForNewNode(hash(key), table.length);
        MyHashMap.MyNode<K, V> nodeToGet;
        V result = null;
        if ((nodeToGet = table[index]) != null) {
            if (nodeToGet.next == null) {
                result = nodeToGet.value;
            } else {
                while (nodeToGet.next != null) {
                    if (hash(nodeToGet.key) == hash(key)) {
                        result = nodeToGet.getValue();
                    }
                }
            }
        }
        return result;
    }


    private static class MyNode<K, V> {
        private final int hash;
        private final K key;
        private V value;
        MyHashMap.MyNode<K, V> next;

        public MyNode(int hash, K key, V value, MyHashMap.MyNode<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V newValue) {
            V oldValue = value;
            value = newValue;
        }

        public final String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof MyHashMap.MyNode) {
                MyHashMap.MyNode<K, V> objectNode = (MyHashMap.MyNode) o;
                if (Objects.equals(key, objectNode.getKey()) &&
                        Objects.equals(value, objectNode.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}

class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> testedHashMap = new MyHashMap<String, String>();
        testedHashMap.put("Key1", "value1");
        testedHashMap.put("Key2", "value2");
        testedHashMap.put("Key2", "value2");
        testedHashMap.put("Key3", "value3");
        testedHashMap.put("Key4", "value4");
        testedHashMap.put("Key5", "value5");
        System.out.println("Size of testedHashMap - " + testedHashMap.size());
        testedHashMap.put("Key6", "value6");
        System.out.println("Size of testedHashMap - " + testedHashMap.size());
        System.out.println("For Key1 value is -  " + testedHashMap.get("Key1"));
        System.out.println("For Key5 value is -  " + testedHashMap.get("Key5"));
        testedHashMap.remove("Key3");
        testedHashMap.remove("Key1");
        System.out.println("TestedHashMap size after removing 2 elements- " + testedHashMap.size());
        testedHashMap.clear();
        System.out.println("TestedHashMap size is - " + testedHashMap.size());

    }

}
