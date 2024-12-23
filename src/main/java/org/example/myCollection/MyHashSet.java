package org.example.myCollection;

import java.util.Arrays;

public class MyHashSet <E>{
    private Object[] elements;
    private int size;

    private static final int INITIAL_CAPACITY = 10;

    public MyHashSet() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    // 요소 추가
    public boolean add(E element) {
        if (contains(element)) {
            return false; // 이미 존재하면 추가하지 않음
        }
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    // 요소 존재 여부 확인
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // 요소 삭제
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    // 용량 확장
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    // 리스트 크기 반환
    public int size() {
        return size;
    }
}


