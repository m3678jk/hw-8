package MyCollections.MyLinkedList;

public class MyLinkedList<E> {
    private int size = 0;
    private MyNode<E> first;
    private MyNode<E> last;

    private static class MyNode<E> {
        private E element;
        private MyNode<E> next;
        private MyNode<E> prev;

        MyNode(MyNode<E> prev, E element, MyNode<E> next) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }
        public MyNode<E> getNext() {
            return next;
        }

        public void setNext(MyNode<E> next) {
            this.next = next;
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


    public void remove(int index) {
            try {
                MyNode<E> x = first;
                for (int i = 0; i < index; i++) {
                    x = x.next;
                }
                removeNode(x);
            } catch (NullPointerException e) {
                System.out.println("Index out of bound");
            }
    }

    void removeNode (MyNode<E> x) {
        final MyNode<E> next = x.next;
        final MyNode<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        size--;
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
        try {
            MyNode<E> node = first;
            for (int i = 0; i < index; i++) {
                node = checkNextElement(node);
            }
            return node.getElement();
        } catch (NullPointerException e) {
            return (E) "Out of list";
        }
    }

    private MyNode<E> checkNextElement(MyNode<E> current) {
        return current.getNext();
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

        testedList.remove(2);

        System.out.println("TestedList after removed element - " + testedList);

        testedList.clear();
        System.out.println("TestedList after cleaning - " + testedList);
        System.out.println("Size of testedList - " + testedList.size());

        MyLinkedList<String> list2 = new MyLinkedList<>();

        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");

        list2.remove(-3);
        list2.remove(2);
        System.out.println(list2);
        System.out.println(list2.get(2));
        list2.size();
        list2.clear();

    }
}