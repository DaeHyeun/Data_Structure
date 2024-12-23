package org.example.sort;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.ceil(Math.random()*100 + 1);
        }
        System.out.println("배열의 길이 : " + arr.length);

        //버블정렬
        long startTime = 0;
        long endTime = 0;
        int[] arr1 = arr.clone();
        startTime =  System.nanoTime();
        sortByBubbleSort(arr1);
        endTime = System.nanoTime();
        System.out.println("버블정렬 시간 : " + ((double) (endTime -startTime)) / 1000000000 );

        //삽입정렬
        int[] arr2 = arr.clone();
        startTime =  System.nanoTime();
        sortByInsertionSort(arr2);
        endTime = System.nanoTime();
        System.out.println("삽입정렬 시간 : " + ((double) (endTime -startTime)) / 1000000000 );

        //힙정렬
        int[] arr3 = arr.clone();
        startTime =  System.nanoTime();
        sortByHeapSort(arr3);
        endTime = System.nanoTime();
        System.out.println("힙정렬 시간 : " + ((double) (endTime -startTime)) / 1000000000 );

        //선택정렬
        int[] arr4 = arr.clone();
        startTime =  System.nanoTime();
        sortBySelectionSort(arr4);
        endTime = System.nanoTime();
        System.out.println("선택정렬 시간 : " + ((double) (endTime -startTime)) / 1000000000 );

        //퀵정렬
        int[] arr5 = arr.clone();
        startTime =  System.nanoTime();
        sortByQuickSort(arr5);
        endTime = System.nanoTime();
        System.out.println("퀵정렬 시간 : " + ((double) (endTime -startTime)) / 1000000000 );

        //병합정렬
        int[] arr6 = arr.clone();
        startTime =  System.nanoTime();
        sortByMergeSort(arr6);
        endTime = System.nanoTime();
        System.out.println("병합정렬 시간 : " + ((double) (endTime -startTime)) / 1000000000 );

        //쉘정렬
        int[] arr7 = arr.clone();
        startTime =  System.nanoTime();
        sortByShellSort(arr7);
        endTime = System.nanoTime();
        System.out.println("쉘정렬 시간 : " + ((double) (endTime -startTime)) / 1000000000 );


    }

    // 배열에서 순서 변경 method
    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    // 버블 정렬(Bubble Sort)
    // 시간 복잡도
    // worst: O(n^2)
    // average: O(n^2)
    // best: O(n^2)
    public static void sortByBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 선택 정렬(Selection Sort)
    // 시간 복잡도
    // worst: O(n^2)
    // average: O(n^2)
    // best: O(n^2)
    public static void sortBySelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    // 삽입 정렬(Insertion Sort)
    // 시간 복잡도
    // worst: O(n^2)
    // average: O(n^2)
    // best: O(n)
    public static void sortByInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while (j >= 0 && tmp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
    }

    // 셸 정렬(Shell Sort)
    // 시간 복잡도
    // worst: O(n^2)
    // average: O(n^1.5)
    // best: O(n)
    public static void sortByShellSort(int[] arr) {
        for (int h = arr.length / 2; h > 0; h /= 2) {
            for (int i = h; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - h;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + h] = arr[j];
                    j -= h;
                }
                arr[j + h] = tmp;
            }
        }
    }
    // 합병(병합) 정렬(Merge Sort)
    // 시간 복잡도
    // worst: O(nlog n)
    // average: O(nlog n)
    // best: O(nlog n)
    // 공간 복잡도
    // O(n)만큼의 추가 메모리 tmpArr 사용

    public static void sortByMergeSort(int[] arr) {
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
    }
    public static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;
            mergeSort(arr, tmpArr, left, m);
            mergeSort(arr, tmpArr, m + 1, right);
            merge(arr, tmpArr, left, m, right);
        }
    }
    public static void merge(int[] arr, int[] tmpArr, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tmpArr[i] = arr[i];
        }
        int part1 = left;
        int part2 = mid + 1;
        int index = left;
        while (part1 <= mid && part2 <= right) {
            if (tmpArr[part1] <= tmpArr[part2]) {
                arr[index] = tmpArr[part1];
                part1++;
            } else {
                arr[index] = tmpArr[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmpArr[part1 + i];
        }
    }

    // 힙 정렬(Heap Sort)
    // 시간 복잡도
    // worst: O(nlog n)
    // average: O(nlog n)
    // best: O(nlog n)
    public static void sortByHeapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i < arr.length; i++) {
            heapify(arr, i, arr.length - 1);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }
    public static void heapify(int[] arr, int parentIdx, int lastIdx) {
        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;
        while (parentIdx * 2 + 1 <= lastIdx) {
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;
            if (arr[leftChildIdx] > arr[largestIdx]) {
                largestIdx = leftChildIdx;
            }
            if (rightChildIdx <= lastIdx && arr[rightChildIdx] > arr[largestIdx]) {
                largestIdx = rightChildIdx;
            }
            if (largestIdx != parentIdx) {
                swap(arr, parentIdx, largestIdx);
                parentIdx = largestIdx;
            } else {
                break;
            }
        }
    }

    // 퀵 정렬(Quick Sort)
    // 시간 복잡도
    // worst: O(n^2)
    // average: O(nlog n)
    // best: O(nlog n)
    public static void sortByQuickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int left, int right) {
        int part = partition(arr, left, right);
        if (left < part - 1) {
            quickSort(arr, left, part - 1);
        }
        if (part < right) {
            quickSort(arr, part, right);
        }
    }
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

}
