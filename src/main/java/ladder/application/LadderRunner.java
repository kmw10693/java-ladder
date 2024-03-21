package ladder.application;

import ladder.domain.Position;
import ladder.domain.Row;

public class LadderRunner {
    // 조합 사용, Row[] 배열 선언
    private final Row[] rows;

    // 의존성 주입(DI) 사용을 통해 필드 초기화
    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    // 현재 포지션을 입력 받아, 마지막 위치를 표현하는 run() 메서드
    public int run(Position position) {

        for (int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position.getValue();
    }

}
