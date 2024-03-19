package ladder.utils;

import ladder.exception.Direction;
import ladder.exception.ExceptionMessage;

import static ladder.exception.ExceptionMessage.*;


public class Row {

    /**
     * 각 행은 Node[] 클래스만을 갖는다. 상속 대신 조합을 사용하자.
     */
    private Node[] nodes;

    /**
     * 각 행의 nodes를 관리해보자.
     * 정적 팩터리 메서드 패턴을 통해 node 배열을 초기화 해보자.
     * 사람의 수를 NaturalNumber를 통해 인스턴스로 받아, Node 배열을 초기화 해보자.
     * from: 하나의 매개 변수를 받아서 객체 생성
     */
    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.get()];
        for (int i = 0; i < numberOfPerson.get(); i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }


    // 포지션을 입력 받아 선을 그어보자.
    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        setDirectionAtPosition(startPosition, Direction.RIGHT);
        setDirectionAtPosition(startPosition.next(), Direction.LEFT);
    }

    private void setDirectionAtPosition(Position startPosition, Direction direction) {
        nodes[startPosition.getValue()] = Node.of(direction);
    }


    // 선을 그리는 위치가 유효한지 판단.
    // 노드의 방향이 이미 정해진 경우를 판단하여 예외 처리한다.
    private void validateDrawLinePosition(Position startPosition) {
        if (validatePosition(startPosition)
                || nodes[startPosition.getValue()].isRight()
                || nodes[startPosition.next().getValue()].isRight()
                || nodes[startPosition.getValue()].isLeft()) {
            throw new IllegalArgumentException(DRAWLINE_POS.getMsg());
        }
    }


    public Position nextPosition(Position currentPosition) {
        validatePosition(currentPosition);
        return nodes[currentPosition.getValue()].move(currentPosition);
    }

    // 검증 메서드
    private boolean validatePosition(Position position) {
        if (position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(POS.getMsg());
        }
        return false;
    }

}
