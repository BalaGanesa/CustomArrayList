package ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomeArrayList<T> {

    private Object[] elements;
    private int size;

    public CustomeArrayList() {
        elements = new Object[10];
        size = 0;
    }

    public void add(T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        elements = new Object[10];
        size = 0;
    }

    public boolean remove(T element) {
        int index = indexOf(element);
        if (index >= 0) {
            T[] newElements = (T[]) new Object[elements.length - 1];
            int newIndex = 0;
            for (int i = 0; i < size; i++) {
                if (i != index) {
                    newElements[newIndex] = (T) elements[i];
                    newIndex++;
                }
            }
            elements = newElements;
            size--;
            return true;
        }
        return false;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
       elements[index] = element;
        size++;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }
    
    private int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public int lastIndexOf(T element) {
        if (element == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    
	public CustomeArrayList clone() {
    	CustomeArrayList clonedList = new CustomeArrayList();
        clonedList.elements = Arrays.copyOf(elements, elements.length);
        clonedList.size = size;
        return clonedList;
    }
    
    
    public void sort() {
        Arrays.sort(elements);
    }

    
    
    
}

