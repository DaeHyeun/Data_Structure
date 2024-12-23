package org.example.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorPractice {
    public static void main(String[] args) {
        String[] arr = {"apple", "Banana", "melon", "grape"};

        Arrays.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));

        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
        System.out.println("arr = " + Arrays.toString(arr));

        Arrays.sort(arr, new Descending());
        System.out.println("arr = " + Arrays.toString(arr));
    }

    static class Descending implements Comparator {
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Comparable && o2 instanceof Comparable) {
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;
                return c1.compareTo(c2) * -1;
            }
            return -1;
        }
    }

}
