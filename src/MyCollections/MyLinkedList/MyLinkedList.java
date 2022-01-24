package MyCollections.MyLinkedList;

import MyCollections.MyHashMap.MyHashMap;

public class MyLinkedList<E> {
    int size = 0;
    MyNode<E> first;
    MyNode<E> last;

    private static class MyNode<E> {
        E element;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(MyNode<E> prev, E element, MyNode<E> next) {
            this.element = element;
        }

        @Override
        public String toString() {
            return String.valueOf(element);
        }
    }

    //get size of MyLinkedList
    public int getSize() {
        return size;
    }

    //add an element into MyLinkedList
    public void add(E data) {
        final MyNode<E> l = last;
        final MyNode<E> f = first;
        // create new Node for input data(type E), next node is null,
        final MyNode<E> newNode = new MyNode<E>(l, data, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;

    }

    @Override
    public String toString() {
        String s = "";
        for (MyLinkedList.MyNode<E> x = first; x != null; x = x.next) {
            s += x + " ";
            //System.out.println(String.valueOf(x));
        }
        return "MyLinkedList {" + s + "}";
    }


    public E remove(int index) {
        if (index >= 0 && index < size) {
            MyLinkedList.MyNode<E> nodeToRemove = (MyNode<E>) get(index);
            System.out.println("node to remove" + nodeToRemove);
            MyLinkedList.MyNode<E> nodeBefore = nodeToRemove.prev;
            MyLinkedList.MyNode<E> nodeNext = nodeToRemove.next;

            MyLinkedList.MyNode<E> z = first;

            if (index == 0) {
                first = z.next;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    z = z.next;
                }
                z.next = nodeNext;
                z.prev = nodeBefore;
            }

            return nodeToRemove.element;
        }


        return null;
    }

    public void clear() {
        for (MyLinkedList.MyNode<E> x = first; x != null; ) {
            MyLinkedList.MyNode<E> next = x.next;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public int size() {
        return getSize();
    }

    public E get(int index) {
        if (index >= 0 && index < size) {
            MyLinkedList.MyNode<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return (E) x;
        }

        return null;
    }
}

class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Integer> testedList = new MyLinkedList<Integer>();
        testedList.add(56);
        System.out.println("testedList after first adding - " + testedList);
        testedList.add(18);
        System.out.println("testedList after second adding - " + testedList);
        testedList.add(1);
        System.out.println("testedList after second adding - " + testedList);
        testedList.add(26);
        System.out.println("testedList after second adding - " + testedList);

        System.out.println("Size of testedList - " + testedList.size());

        System.out.println("Element from specific index 1 - " + testedList.get(1));

        System.out.println("Removed element from 2 index - " + testedList.remove(2));

        System.out.println("TestedList after removed element - " + testedList);

        testedList.clear();
        System.out.println("TestedList after cleaning - " + testedList);
        System.out.println("Size of testedList - " + testedList.size());

    }
}