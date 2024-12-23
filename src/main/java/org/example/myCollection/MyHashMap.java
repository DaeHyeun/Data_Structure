package org.example.myCollection;

import java.util.Arrays;

public class MyHashMap<K, V>{
    private Object[] keys;
    private Object[] values;
    private int size;

    private static final int INITIAL_CAPACITY = 10;

    public MyHashMap() {
        this.keys = new Object[INITIAL_CAPACITY];
        this.values = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    // 요소 추가
    public void put(K key, V value) {
        ensureCapacity();
        keys[size] = key;
        values[size++] = value;
    }

    // 키에 해당하는 값 반환
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null; // 키가 없으면 null 반환
    }

    // 요소 삭제
    public boolean remove(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                System.arraycopy(keys, i + 1, keys, i, size - i - 1);
                System.arraycopy(values, i + 1, values, i, size - i - 1);
                keys[--size] = null;
                values[size] = null;
                return true;
            }
        }
        return false;
    }

    // 용량 확장
    private void ensureCapacity() {
        if (size == keys.length) {
            keys = Arrays.copyOf(keys, keys.length * 2);
            values = Arrays.copyOf(values, values.length * 2);
        }
    }

    // 리스트 크기 반환
    public int size() {
        return size;
    }
}
