package org.example.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorPractice {
    public static void main(String[] args) {
        String[] arr = {"apple", "Banana", "melon", "grape"};

        // 1. Comparable을 사용하여 자연순서(알파벳순)로 정렬
        Arrays.sort(arr);  // 문자열은 이미 Comparable을 구현하고 있음
        System.out.println("Comparable 정렬 (알파벳순): " + Arrays.toString(arr));

        // 2. Comparator를 사용하여 대소문자 구분 없이 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                // 대소문자 구분 없이 비교
                return str1.toLowerCase().compareTo(str2.toLowerCase());
            }
        });
        System.out.println("Comparator 정렬 (대소문자 구분 없이): " + Arrays.toString(arr));
    }

}
