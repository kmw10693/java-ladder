package ladder.exception;

public enum ExceptionMessage {
    /**
     * enum 열거 타입으로 예외 메시지 설정 한다.
     * enum 클래스로 쉽게 관리 가능 하다.
     */
    INVALID_LADDER_POSITION("게임의 참여자 수는 1명 이상이어야 합니다."),
    INVALID_DRAW_POSITION("라인 생성이 불가능한 위치입니다."),
    INVALID_POSITION("유효하지 않은 위치입니다.");

    /**
     * INVALID_LADDER_POSITION = "게임의 참여자 수는 1명 이상이어야 합니다."
     * INVALID_DRAW_POSITION = "라인 생성이 불가능한 위치입니다."
     * INVALID_POSITION = "유효하지 않은 위치입니다."
     */
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
    /**
     * ExceptionMessage.NUMBER_OF_PERSON.getMessage()를 통해, 예외 메시지를 출력 가능 하다.
     */
    public String getMessage() {
        return message;
    }

}
