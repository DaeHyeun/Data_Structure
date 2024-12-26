package org.example.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

class Student {
    //field
    int mathScore; // 수학점수
    int engScore;  // 영어점수

    //constructor
    public Student(int mathScore, int engScore){
        this.mathScore = mathScore;
        this.engScore = engScore;
    }

    // toString() 메소드 추가하여 객체 출력 시 보기 쉽게 수정
    @Override
    public String toString() {
        return String.format("MathScore: %d, EnglishScore: %d", mathScore, engScore);
    }

    // equals()와 hashCode() 메소드 오버라이드
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return mathScore == student.mathScore && engScore == student.engScore;
    }

    @Override
    public int hashCode() {
        return 31 * mathScore + engScore;
    }
}

// 클래스 객체의 우선순위를 위한 클래스
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.mathScore == o2.mathScore) {
            return o2.engScore - o1.engScore; //수학점수가 같은 경우 영어점수가 높은 학생이 우선순위가 더 높다.
        } else {
            return o1.mathScore - o2.mathScore; //수학점수가 낮은 학생이 우선순위가 더 높다
        }
    }
}

public class PriorityQueueExample {
    public static void main(String[] args) {

        // 클래스 객체에 대한 우선순위 기준 제공
        PriorityQueue<Student> pQ = new PriorityQueue<>(1, new StudentComparator());
        // 학생 객체를 우선순위 큐에 추가
        pQ.offer(new Student(70, 50));
        pQ.offer(new Student(60, 50));
        pQ.offer(new Student(70, 40));
        pQ.offer(new Student(80, 90));
        pQ.offer(new Student(75, 85));

        // 큐의 상태 출력
        System.out.println("===== 우선순위 큐 예제 =====");
        System.out.println("큐에 학생 추가:");
        for (Student s : pQ) {
            System.out.println(s);
        }

        // 큐에서 우선순위가 가장 높은 학생을 확인 (peek)
        System.out.println("\n우선순위 높은 학생(Top)(peek): " + pQ.peek());

        // 큐에서 학생을 하나씩 꺼내서 출력 (poll)
        System.out.println("\n학생 하나씩 꺼내면서 출력(poll):");
        while (!pQ.isEmpty()) {
            Student s = pQ.poll();
            System.out.println(s);
        }

        // 큐에 다시 학생 추가
        System.out.println("\n학생들 확인한 후 큐 사이즈 : " + pQ.size());
        pQ.offer(new Student(60, 70));
        System.out.println("\n추가된 학생:(Math:60 , Eng:70)");
        pQ.offer(new Student(85, 95));
        System.out.println("추가된 학생:(Math:85 , Eng:95)");

        // 큐의 크기 확인
        System.out.println("\n빈 큐에 학생 추가하고 사이즈 확인: " + pQ.size());

        // 큐에서 특정 학생 객체 제거 (remove)
        Student studentToRemove = new Student(70, 50);
        boolean removed = pQ.remove(studentToRemove);
        System.out.println("\n삭제된 학생 (Math: 70, English: 50): " + removed);

        Student studentRemove = new Student(60, 70);
        boolean remove = pQ.remove(studentRemove);
        System.out.println("삭제된 학생 (Math: 60, English: 70): " + remove);

        // 큐에서 남은 학생들 출력
        System.out.print("\n큐안에 남은 학생: ");
        while (!pQ.isEmpty()) {
            Student s = pQ.poll();
            System.out.println(s);
        }

        // 큐 상태 확인 (빈 큐일 때)
        System.out.println("\n큐가 비어있니??? " + pQ.isEmpty());


    }
}
