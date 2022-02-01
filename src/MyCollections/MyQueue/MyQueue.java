package MyCollections.MyQueue;

import java.util.Arrays;

public class MyQueue<E> {

    private E[] queue = (E[]) new Object[]{};
    private Object [] changedQueue;
    private E element;

    public void setQueue(E[] array) {
        this.queue = array;
    }

    public E[] getQueue() {
        return queue;
    }


    public void add(E element) {

        // create Object Array with element which is given
        Object[] arrayWithNewElement = {element};

        // extend length of new Array
        changedQueue = new Object [queue.length +1];

        // Copy objects from base array to new one
        System.arraycopy(getQueue(), 0, changedQueue, 0, getQueue().length);
        System.arraycopy(arrayWithNewElement, 0, changedQueue, queue.length, 1);

        // return new array with added element
        setQueue((E[])changedQueue);

    }

public void remove(int index) {
    if (index >= getQueue().length){
        System.out.println("Incorrect index");
    } else {
        // create Object Array based on elements from income array
        Object[] arrayToChange = Arrays.copyOf(getQueue(), getQueue().length);

        // reduce length of new Array
        changedQueue = new Object[arrayToChange.length -1];

        // Copy objects from base array to new one
        System.arraycopy(arrayToChange,0,changedQueue, 0,index);
        System.arraycopy(arrayToChange,index+1 ,changedQueue, index,arrayToChange.length-index-1);

        // return new array without removed element
        setQueue((E[])changedQueue);
    }


}

    public void clear() {

        changedQueue = new Object[0];

        setQueue((E[])changedQueue);
    }


    public int size(){
        return getQueue().length;
    }

    public E peek(){
        try {
            return getQueue()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Size = " + size() + ", Queue is empty");
            return null;
        }
    }

    public E poll(){
        try {
                E element = getQueue()[0];
                Object[] arrayToChange = Arrays.copyOf(getQueue(), getQueue().length);

                // reduce length of new Array
                changedQueue = new Object[arrayToChange.length - 1];

                // Copy objects from base array to new one
                System.arraycopy(arrayToChange, 1, changedQueue, 0, arrayToChange.length - 1);
                setQueue((E[]) changedQueue);
                return element;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Size = " + size() + ", Queue is empty");
            return null;
        }
    }
}
class MyQueueTest{
    public static void main(String[] args) {
        MyQueue<String> testedQueue = new MyQueue<>();

        System.out.println("Queue before changes - " + Arrays.toString(testedQueue.getQueue()));
        testedQueue.add("A");
        System.out.println("Queue after adding one element - "+ Arrays.toString(testedQueue.getQueue()));
        testedQueue.add("B");
        System.out.println("Queue after adding one element - "+ Arrays.toString(testedQueue.getQueue()));
        testedQueue.add("Y");
        System.out.println("Queue after adding one element - "+ Arrays.toString(testedQueue.getQueue()));
        testedQueue.add("Z");
        System.out.println("Queue after adding one element - "+ Arrays.toString(testedQueue.getQueue()));

        System.out.println("Size of queue - "+testedQueue.size());

        testedQueue.remove(2);
        System.out.println("Size of queue after removing an element - "+ testedQueue.size());

        System.out.println("Peeked element - "+ testedQueue.peek());
        System.out.println("Polled element - "+ testedQueue.poll());

        System.out.println("Queue after polled element - "+ Arrays.toString(testedQueue.getQueue()));
        testedQueue.clear();
        System.out.println("Queue after cleaning - "+ Arrays.toString(testedQueue.getQueue()));
        testedQueue.peek();
    }
}