package org.example.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DequeTestClass {
    public static void main(String[] args) throws InterruptedException {

        // Stack 구현 (addFirst, removeFirst, peekFirst 등 사용)
        System.out.println("Stack!!");
        Deque<String> stack = new ArrayDeque<>();
        stack.addFirst("Element1");
        stack.addFirst("Element2");
        stack.addFirst("Element3");

        // Stack의 최상위 요소를 확인만 하고 제거하지 않기 (peekFirst)
        System.out.println("=====================================================");
        System.out.println(stack);
        System.out.println("Top of Stack (peekFirst): " + stack.peekFirst());
        System.out.println("bottom of Stack (peekLast): " + stack.peekLast());
        System.out.println("=====================================================");
        System.out.println();

        // Stack에서 요소를 하나씩 제거하면서 출력
        System.out.println("=====================================================");
        while (!stack.isEmpty()) {
            System.out.println("Removed from Stack: " + stack.removeFirst());
        }
        System.out.println("=====================================================");
        System.out.println();

        // Queue 구현 (addLast, removeFirst, peekFirst 등 사용)
        System.out.println("\nQueue!!");
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast("Element1");
        queue.addLast("Element2");
        queue.addLast("Element3");

        // Queue의 첫 번째 요소를 확인만 하고 제거하지 않기 (peekFirst)
        System.out.println("=====================================================");
        System.out.println(queue);
        System.out.println("Front of Queue (peekFirst): " + queue.peekFirst());
        System.out.println("Back of Queue (peekLast): " + queue.peekLast());
        System.out.println("=====================================================");
        System.out.println();

        System.out.println("=====================================================");
        // Queue에서 요소를 하나씩 제거하면서 출력
        while (!queue.isEmpty()) {
            System.out.println("Removed from Queue: " + queue.removeFirst());
        }
        System.out.println("=====================================================");
        System.out.println();

        // 추가적인 기능들
        System.out.println("\nAdditional Deque Operations!!");

        // Deque의 양쪽에서 요소를 추가하고 제거하는 예시
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");
        deque.addLast("B");
        deque.addFirst("C");
        deque.addLast("D");

        System.out.println("=====================================================");
        System.out.println("Deque after addFirst and addLast:");
        System.out.println(deque);  // 출력: [C, A, B, D]
        System.out.println("=====================================================");
        System.out.println();

        // 양쪽에서 요소를 제거하는 예시
        System.out.println("=====================================================");
        System.out.println("Removed from front: " + deque.removeFirst());  // C
        System.out.println("Removed from end: " + deque.removeLast());    // D
        System.out.println("=====================================================");
        System.out.println();

        System.out.println("=====================================================");
        System.out.println("Deque after remove operations:");
        System.out.println(deque);  // 출력: [A, B]
        System.out.println("=====================================================");
        System.out.println();

        // 요소를 검색하는 방법 (contains)
        System.out.println("=====================================================");
        System.out.println("Deque contains 'B': " + deque.contains("B"));  // true
        System.out.println("Deque contains 'D': " + deque.contains("D"));  // false
        System.out.println("=====================================================");
        System.out.println();

        // peekLast를 사용하여 Deque의 마지막 요소 확인
        System.out.println("=====================================================");
        System.out.println("Last element of Deque (peekLast): " + deque.peekLast());  // B
        System.out.println("=====================================================");
    }
}
