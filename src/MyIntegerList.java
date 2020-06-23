import java.util.*;

public class MyIntegerList implements List<Integer> {
    private int[] myList = new int[0];

    public MyIntegerList() {
    }


    @Override
    public int size() {
        return myList.length;
    }

    @Override
    public boolean isEmpty() {
        return myList.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Integer e : myList) {
            if (e.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return new int[][]{myList};
    }

    @Override
    public boolean add(Integer o) {
        int[] myNewList = Arrays.copyOf(myList, myList.length + 1);
        myNewList[myList.length] = o;
        myList = myNewList;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == (int) o) {
                if (myList.length - 1 - i >= 0) System.arraycopy(myList, i + 1, myList, i, myList.length - 1 - i);
                int[] listWithRemovedElement = new int[myList.length - 1];
                System.arraycopy(myList, 0, listWithRemovedElement, 0, myList.length - 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        int[] newList = new int[myList.length + c.size()];
        int aLen = myList.length;
        int bLen = newList.length;
        System.arraycopy(myList, 0, newList, 0, aLen);
        System.arraycopy(c.toArray(), 0, newList, aLen + 1, bLen);
        return checkMyList(newList);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        indexOutOfBoundException(index);
        Object[] arrayToAdd = c.toArray();
        int[] newList = new int[myList.length + c.size()];
        System.arraycopy(myList, 0, newList, 0, index);
        System.arraycopy(arrayToAdd, 0, newList, index, arrayToAdd.length);
        System.arraycopy(myList, index, newList, index + arrayToAdd.length, myList.length - index);
        return checkMyList(newList);
    }

    @Override
    public void clear() {
        myList = new int[0];
    }

    @Override
    public Integer get(int index) {
        return myList[index];
    }


    @Override
    public Integer set(int index, Integer element) {
        int previousElement = myList[index];
        myList[index] = element;
        return previousElement;
    }

    @Override
    public void add(int index, Integer element) {
        indexOutOfBoundException(index);
        int[] newList = new int[myList.length + 1];
        System.arraycopy(myList, 0, newList, 0, index);
        newList[index + 1] = element;
        System.arraycopy(myList, index, newList, index + 1, myList.length - index);
    }

    @Override
    public Integer remove(int index) {
        int removedElement = myList[index];
        int[] newList = new int[myList.length - 1];

        System.arraycopy(myList, 0, newList, 0, index);
        System.arraycopy(myList, index + 1, newList, index, myList.length - index);
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        int result = -1;
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == (int) o) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(Object o) {
        int result = -1;
        for (int i = myList.length - 1; i > 0; i--) {
            if (myList[i] == (int) o) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private boolean checkMyList(int[] newList) {
        if (Arrays.equals(newList, myList)) {
            return false;
        } else {
            myList = newList;
            return true;
        }
    }

    private void indexOutOfBoundException(int index) {
        if (index >= myList.length) {
            throw new IllegalArgumentException("Index is out of bound of the source");
        }
    }
}
