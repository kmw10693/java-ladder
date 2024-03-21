package ladder.domain;

import ladder.exception.ExceptionMessage;

public class NaturalNumber {
    /**
     * numberOfPerson, numberOfRow 값은 둘다 프리미티브값을 가지며, 예외처리를 해줘야 한다.
     * NaturalNumber 클래스로 만들어 예외 처리를 쉽게 관리해보자.
     */
    private final int number;

    /**
     * 생성자를 외부에서 호출못하게 private으로 지정하자.
     * 정적 팩터리 메서드 패턴을 통해 인스턴스를 반환해보자.
     */
    private NaturalNumber(int number) {
        validate(number);
        this.number = number;
    }

    /**
     * validate 메서드와 isNaturalNumber 메서드를 분리해보자.
     * 단순히 if 문에 number >= 1을 통해 조건을 분기하는 것보다 메서드를 분리하여 관리해보자.
     * @param number
     */
    private static void validate(int number) {
        if (!isNaturalNumber(number)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isNaturalNumber(int number) {
        return number >= 1;
    }

    public int getNumber() {
        return number;
    }

    // 정적 팩터리 메서드 패턴
    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

}
