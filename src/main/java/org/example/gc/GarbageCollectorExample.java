package org.example.gc;


class LargeObject {
    private String name;
    private int[] data;

    // 생성자에서 큰 배열을 생성하여 메모리 차지
    public LargeObject(String name) {
        this.name = name;
        data = new int[100000];  // 예시로 매우 큰 배열 할당
        System.out.println(name + "생성!");
        System.out.println(".....");
    }

    protected String getName (){
        return name;
    }

    // 객체가 더 이상 사용되지 않으면 가비지 컬렉터가 호출할 수 있는 메소드
    @Override
    protected void finalize() throws Throwable {
        try {
            // finalize()에서 getName() 호출 시 오류가 나지 않도록 안전하게 처리
            if (this != null) {
                System.out.println(this.name + " 객체가 가비지 컬렉션 대상이 되었습니다.");
                System.out.println("삭제중 ......");
            } else {
                System.out.println("객체가 이미 null로 처리되어 삭제되지 않았습니다.");
            }
            System.out.println( this.name + " 객체가 쓰레기로 인식되어 삭제됨!\n");

        } finally {
            super.finalize();  // 반드시 super.finalize()를 호출하여 부모 클래스의 finalize()도 실행되게 합니다.
        }
    }
}

public class GarbageCollectorExample {
    public static void main(String[] args) {

        // 대형 객체 생성
        LargeObject obj1 = new LargeObject("거대객체 1");
        LargeObject obj2 = new LargeObject("거대객체 2");

        // 객체를 더 이상 사용하지 않음 (obj1은 더 이상 참조되지 않음)
        System.out.println("\n" + obj1.getName() + " to Grabage \n");
        obj1 = null;

        // 가비지 컬렉터 호출 요청
        System.gc();  // System.gc()로 가비지 컬렉션을 명시적으로 요청

        // obj2 객체는 여전히 사용 중이므로 가비지 컬렉션 대상이 아님
        // obj2는 메모리에서 해제되지 않음

        // 약간의 시간 지연 후 가비지 컬렉터 동작을 보기 위해 sleep
        try {
            Thread.sleep(2000);  // 2초 정도 기다리며 가비지 컬렉터가 동작할 시간을 줍니다.
            System.out.println(obj2.getName() + "의 클래스" + obj2.getClass());
            System.out.println(obj1.getClass());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NullPointerException t){
            System.out.println("거대객체 1의 클래스 값은 : null");
        }

        // obj2는 여전히 유효하므로 finalize() 호출되지 않음
    }
}