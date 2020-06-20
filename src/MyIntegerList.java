import java.util.*;

public class MyIntegerList implements List {
    private int myList[] = new int[];

    public MyIntegerList() {
    }


    @Override
    public int size() {
        return myList.length;
    }

    @Override
    public boolean isEmpty() {
        if (myList.length == 0) {
            return true;
        } else {
            return false;
        }
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
        return null;
    }

    @Override
    public Object[] toArray() {
        return new int[][]{myList};
    }

    @Override
    public boolean add(Object o) {
        int[] myNewList = Arrays.copyOf(myList, myList.length + 1);
        myNewList[myList.length] = (int) o;
        myList = myNewList;
        ;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == (int) o) {
                for (int j = i; j < myList.length - 1; j++) {
                    myList[j] = myList[j + 1];
                }
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
        System.arraycopy(c.toArray(), 0, newList, aLen, bLen);
        return checkMyList(newList);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Object[] arrayToAdd = c.toArray();

        int[] newList = new int[myList.length + c.size()];

        for (int i = 0; i < index; i++) {
            newList[i] = myList[i];
        }
        for (int i = index; i < index + c.size(); i++) {
            newList[i] = (int) arrayToAdd[i - index];
        }
        for (int i = index + c.size(); i < newList.length ; i++) {
            newList[i] = myList[i];
        }
        return checkMyList(newList);
    }

    @Override
    public void clear() {
        myList = new int[0];
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
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
        if (newList.equals(myList)) {
            return false;
        } else {
            myList = newList;
            return true;
        }
    }
}
