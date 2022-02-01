package MyCollections.MyStack;

import java.util.Arrays;

public class MyStack<E> {

    private E[] stack = (E[]) new Object[]{};
    public Object[] changedStack;
    public E element;

    public void setStack(E[] stack) {
        this.stack = stack;
    }

    public E[] getStack() {
        return stack;
    }


    public void push(E element) {
        // create Object Array with element which is given
        Object[] arrayWithNewElement = {element};

        // extend length of new Array
        changedStack = new Object[getStack().length + 1];

        // Copy objects from base array to new one
        System.arraycopy(getStack(), 0, changedStack, 0, getStack().length);
        System.arraycopy(arrayWithNewElement, 0, changedStack, getStack().length, 1);
        setStack((E[]) changedStack);
    }

    public void remove(int index) {
        if (index >= getStack().length) {
            System.out.println("Incorrect index");
        } else {
            // create Object Array based on elements from income array
            Object[] arrayToChange = Arrays.copyOf(getStack(), getStack().length);

            // reduce length of new Array
            changedStack = new Object[arrayToChange.length - 1];

            // Copy objects from base array to new one
            System.arraycopy(arrayToChange, 0, changedStack, 0, index);
            System.arraycopy(arrayToChange, index + 1, changedStack, index, arrayToChange.length - index - 1);

            // return new array without removed element
            setStack((E[]) changedStack);
        }
    }


    public void clear() {

        changedStack = new Object[0];

        setStack((E[]) changedStack);
    }


    public int size() {
        return getStack().length;
    }

    public E peek() {
        try {
            return getStack()[getStack().length - 1];
        }catch (ArrayIndexOutOfBoundsException e){
              System.out.println("Size = "+  size() +", Stack is empty");
                return null;

        }
    }

    public E pop() {
        try {
                       E element = getStack()[getStack().length - 1];
            Object[] arrayToChange = Arrays.copyOf(getStack(), getStack().length);

            // reduce length of new Array
            changedStack = new Object[arrayToChange.length - 1];

            // Copy objects from base array to new one
            System.arraycopy(arrayToChange, 0, changedStack, 0, arrayToChange.length - 1);
            setStack((E[]) changedStack);
            return element;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Size = "+  size() +", Stack is empty");
            return null;
        }
    }
}

class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> testedStack = new MyStack<Integer>();
        testedStack.push(1);
        System.out.println("Stack after adding an element - " + Arrays.toString(testedStack.getStack()));

        testedStack.push(2);
        System.out.println("Stack after adding an element - " + Arrays.toString(testedStack.getStack()));

        testedStack.push(3);
        System.out.println("Stack after adding an element - " + Arrays.toString(testedStack.getStack()));

        testedStack.push(4);
        System.out.println("Stack after adding an element - " + Arrays.toString(testedStack.getStack()));

        testedStack.push(5);
        System.out.println("Stack after adding an element - " + Arrays.toString(testedStack.getStack()));

        testedStack.remove(1);
        System.out.println("Stack after removing an element - " + Arrays.toString(testedStack.getStack()));

        System.out.println("Size of stack - " + testedStack.size());

        System.out.println("Peeked element is - " + testedStack.peek());

        System.out.println("Popped element is - " + testedStack.pop());

        System.out.println("Stack after popping an element - " + Arrays.toString(testedStack.getStack()));

        testedStack.clear();
        System.out.println("Stack after clearing - " + Arrays.toString(testedStack.getStack()));

        testedStack.pop();

    }
}