package ladder.exception;

public enum ExceptionMessage {

    /**
     * enum 열거 타입으로 예외 메시지 설정한다
     * enum 클래스로 쉽게 관리 가능하다.
     */
    NUMBER_OF_PERSON("게임의 참여자 수는 1명 이상이어야 합니다."),
    DRAWLINE_POS("라인 생성이 불가능한 위치입니다."),
    POS("유효하지 않은 위치입니다.");

    /**
     * NUMBER_OF_PERSON = "게임의 참여자 수는 ... 합니다."
     * DRAWLINE_POS = "라인 생성이 .. 위치입니다."
     * POS = "유효하지 .. 위치입니다."
     */
    private String msg;

    ExceptionMessage(String msg) {
        this.msg = msg;
    }

    /**
     * ExceptionMessage.NUMBER_OF_PERSON.getMsg()를 통해, 예외 메시지를 출력 가능하다.
     */
    public String getMsg() {
        return msg;
    }
}
