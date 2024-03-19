package ladder.exception;

public enum Direction {
    /**
     * enum 열거 타입으로 예외 메시지 설정한다.
     * enum 클래스로 쉽게 관리 가능하다.
     */
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    /**
     * RIGHT(1) direcitons = 1
     * LEFT(-1) directions = -1
     * NONE(0) = directions = 0
     */
    private final int directions;

    Direction(int directions) {
        this.directions = directions;
    }

}
