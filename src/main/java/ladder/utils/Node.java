package ladder.utils;

import ladder.exception.Direction;

/**
 * 각 행은 Node를 통해서 관리한다.
 *  상속 대신 조합 (Compositon)을 통해 클래스를 관리해보자.
 *  상속은 상위 클래스가 변경되면 하위 클래스까지 변경되어, 의존성이 강한 코드가 만들어진다.
 */
public class Node {

    // 필드는 Direction 클래스를 갖는다. 조합 사용
    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public Position move(Position position) {
        if (isRight()) {
            return position.next();
        }
        if (isLeft()) {
            return position.prev();
        }
        return position;
    }

    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public boolean isLeft() {
        return direction == Direction.LEFT;
    }

    // 정적 팩터리 메서드 패턴
    public static Node of(Direction direction) {
        return new Node(direction);
    }


}
