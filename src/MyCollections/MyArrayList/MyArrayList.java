package MyCollections.MyArrayList;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] array = (T[]) new Object[]{};

    private Object[] changedArray;

    public void setArray(T[] array) {
        this.array = (T[]) array;
    }

    public T[] getArray() {
        return array;
    }


    public void add(T element) {

        Object[] arrayWithElement = {element};

        // extend length of new Array
        changedArray = new Object[array.length + 1];

        // Copy objects from base array to new one
        System.arraycopy(getArray(), 0, changedArray, 0, getArray().length);
        System.arraycopy(arrayWithElement, 0, changedArray, array.length, 1);

        // set new array with added element
        setArray((T[]) changedArray);

    }

    public void remove(int index) {
        if (index < 0 || index >= getArray().length ) {
            System.out.println("Incorrect index");
        } else {
            // create Object Array based on elements from income array
            Object[] arrayToChange = Arrays.copyOf(getArray(), getArray().length);

            // reduce length of new Array
            changedArray = new Object[arrayToChange.length - 1];

            // Copy objects from base array to new one
            System.arraycopy(arrayToChange, 0, changedArray, 0, index);
            System.arraycopy(arrayToChange, index + 1, changedArray, index, arrayToChange.length - index - 1);

            // return new array without removed element
            setArray((T[]) changedArray);
        }


    }

    public void clear() {
        changedArray = new Object[0];
        setArray((T[]) changedArray);
    }

    public int size() {
        return getArray().length;
    }

    public T get(int index) {
        if (index > getArray().length) {
            System.out.println("Size of arrayList is - "+ size() + " please enter index which less that size");
            return null;
        } else {
            return getArray()[index];

        }
    }


}

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> testedArray = new MyArrayList<String>();

        testedArray.add("A");
        System.out.println("Array after adding one element - " + Arrays.toString(testedArray.getArray()));

        testedArray.add("B");
        System.out.println("Array after adding one element - " + Arrays.toString(testedArray.getArray()));

        testedArray.add("C");
        System.out.println("Array after adding one element - " + Arrays.toString(testedArray.getArray()));

        testedArray.add("D");
        System.out.println("Array after adding one element - " + Arrays.toString(testedArray.getArray()));

        testedArray.remove(0);
        System.out.println(("Array after removing element - " + Arrays.toString(testedArray.getArray())));

        testedArray.size();
        System.out.println("Size of array - " + testedArray.size());

        System.out.println("Element - " + testedArray.get(2));

        testedArray.clear();
        System.out.println(("Array after clearing - " + Arrays.toString(testedArray.getArray())));


    }
}