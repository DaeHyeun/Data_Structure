package org.example.myCollection;

public class MyArrayList<E> {
    private Object[] elementData;  // 배열로 내부 데이터를 저장
    private int size;              // 현재 리스트의 요소 개수

    private static final int INITIAL_CAPACITY = 10; // 초기 용량

    public MyArrayList() {
        this.elementData = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    // 요소 추가
    public void add(E element) {
        ensureCapacity(); // 용량이 충분한지 확인하고, 부족하면 확장
        elementData[size++] = element; // 요소를 추가하고 size 증가
    }


    // 특정 인덱스에 요소 추가
    public void add(int index, E element) {
        rangeCheckForAdd(index);  // 인덱스가 유효한지 확인
        ensureCapacity();         // 용량이 충분한지 확인
        System.arraycopy(elementData, index, elementData, index + 1, size - index); // 요소 이동
        elementData[index] = element; // 새 요소 삽입
        size++; // 크기 증가
    }

    // 특정 인덱스의 요소 반환
    public E get(int index) {
        rangeCheck(index); // 인덱스가 유효한지 확인
        return (E) elementData[index];
    }

    // 특정 인덱스의 요소 제거
    public E remove(int index) {
        rangeCheck(index); // 인덱스가 유효한지 확인
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null; // 요소 제거 후 null로 설정
        return oldValue;
    }

    // 리스트 크기 반환
    public int size() {
        return size;
    }

    // 용량이 충분한지 확인하고, 부족하면 확장
    private void ensureCapacity() {
        if (size == elementData.length) {
            int newCapacity = elementData.length * 2;
            elementData = java.util.Arrays.copyOf(elementData, newCapacity);
        }
    }

    // 범위 체크 (인덱스가 유효한지)
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    // 범위 체크 (추가 시 유효한 인덱스인지)
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}
