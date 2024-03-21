package ladder.domain;


import ladder.exception.ExceptionMessage;

/**
 * 필드를 position만 갖는 이유를 생각 해보자.
 * primitive type 으로는 컴파일러가 의미적으로 프로그램 작성을 안내할 수 없다.
 * 포장한 객체를 통해 예외 처리 가능하다.
 */
public class Position {
    private int position;

    /**
     * 생성자의 접근 제어자를 private으로 설정하여
     * 오직 정적 팩터리 메서드를 통해 인스턴스 반환한다.
     * 생성자는 캡슐화를 방해할 수 있다.

     * @param position
     */
    private Position(int position) {
        this.position = position;
    }

    /**
     * static의 특징은 무엇 일까?
     * 1. 메모리에 고정적으로 할당된다.
     * 2. 객체 생성 없이 사용할 수 있다.
     * 3. 프로그램이 시작되면 메모리의 static 영역에 적재되고, 프로그램이 종료될 때 해제된다.
     * 4. Static 메서드 내에서는 인스턴스 변수를 사용할 수 없다.
     *
     * 정적 팩터리 메서드 패턴을 통해, 객체 생성없이 인스턴스를 반환해보자.
     *
     * 정적 팩토리 메서드 네이밍 컨벤션
     * from : 하나의 매개 변수를 받아서 객체를 생성
     * of : 여러개의 매개 변수를 받아서 객체를 생성
     * @param position
     * @return
     */
    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    // 이전 포지션 리턴 메서드
    public Position prev() {
        return of(position - 1);
    }

    // 다음 포지션 리턴 메서드
    public Position next() {
        return of(position + 1);
    }

    // 포지션을 가져와 필드와 작은지 비교하는 메서드
    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    // 포지션을 가져와 필드와 큰지 비교하는 메서드
    public boolean isBiggerThan(int position) {
        return this.position > position;
    }

    public int getValue() {
        return position;
    }

    /**
     * 포지션이 유효한지 검증하는 메서드
     * 정적 팩터리 메서드 패턴을 사용하여, private static 접근 제어자를 사용하였음.
     * isPosition을 분리함으로써, 예외 변경시 isPosition을 변경 용이하도록 하였음.
     *
     * @param position
     */
    private static void validatePosition(int position) {
        if(!isPosition(position)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

}
