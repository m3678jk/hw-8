package MyCollections.MyArrayList;

import java.util.Arrays;

class MyArrayList <T> {
    private T[] array;
    public Object [] changedArray;
    public T element;


    public void setArray(T[] array) {
        this.array = (T[]) array;
    }

    public T[] getArray() {
        return array;
    }


    public void add(T[] array, T element) {

        // create Object Array based on elements from income array
        Object[] arrayToChange = Arrays.copyOf(array, array.length);

        // extend length of new Array
        changedArray = new Object [array.length +1];

        // Copy objects from base array to new one
        System.arraycopy(arrayToChange, 0, changedArray, 0, arrayToChange.length);

        int size = changedArray.length;

        // add new element in the end
        changedArray [size-1]= element;

        // return new array with added element
        setArray((T[])changedArray);

    }

    public void remove(int index) {
        if (index >= getArray().length){
            System.out.println("Incorrect index");
        } else {
            // create Object Array based on elements from income array
            Object[] arrayToChange = Arrays.copyOf(getArray(), getArray().length);

            // reduce length of new Array
            changedArray = new Object[arrayToChange.length -1];

            // Copy objects from base array to new one
            System.arraycopy(arrayToChange,0,changedArray, 0,index);
            System.arraycopy(arrayToChange,index+1 ,changedArray, index,arrayToChange.length-index-1);

            // return new array without removed element
            setArray((T[])changedArray);
        }


    }

    public void clear() {
        // create Object Array based on elements from income array
        Object[] arrayToChange = Arrays.copyOf(getArray(), getArray().length);
        // reduce length of new Array

        changedArray = new Object[arrayToChange.length];
//        for (int i =0 ; i < arrayToChange.length; i++){
//            changedArray[i]=null;
//        }

        setArray((T[])changedArray);
    }

    public int size() {
        return getArray().length;
    }

    public T get(int index){

        System.out.println();
        return getArray()[index];
    }



}

class MyArrayListTest{
    public static void main(String[] args) {
        MyArrayList <String> testedArray = new MyArrayList<String>();
        String [] arrayString = new String[]{"g", "r", "w"};

        testedArray.setArray(arrayString);
        System.out.println("Array before changes - " + Arrays.toString(testedArray.getArray()));

        testedArray.add(arrayString, "new one");
        System.out.println("Array after adding one element - "+ Arrays.toString(testedArray.getArray()));

        testedArray.remove(0);
        System.out.println(("Array after removing element - "+ Arrays.toString(testedArray.getArray())));

        testedArray.clear();
        System.out.println(("Array after clearing - "+ Arrays.toString(testedArray.getArray())));

        testedArray.size();
        System.out.println("Size of array - " + testedArray.size());

        testedArray.get(2);
        System.out.println("Element - " + testedArray.get(2));

    }
}