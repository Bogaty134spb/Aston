package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList<E> {
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        elements = new Object[10];
        size = 0;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] collectionArray = c.toArray();
        int collectionSize = collectionArray.length;
        ensureCapacity(size + collectionSize);
        System.arraycopy(collectionArray, 0, elements, size, collectionSize);
        size += collectionSize;
        return collectionSize > 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void sort(Comparator<? super E> c) {
        quickSort(0, size - 1, c);
    }

    private void quickSort(int low, int high, Comparator<? super E> c) {
        if (low < high) {
            int pivotIndex = partition(low, high, c);
            quickSort(low, pivotIndex - 1, c);
            quickSort(pivotIndex + 1, high, c);
        }
    }

    private int partition(int low, int high, Comparator<? super E> c) {
        E pivot = (E) elements[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (c.compare((E) elements[j], pivot) <= 0) {
                i++;
                swapElements(i, j);
            }
        }

        swapElements(i + 1, high);
        return i + 1;
    }

    private void swapElements(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

}


