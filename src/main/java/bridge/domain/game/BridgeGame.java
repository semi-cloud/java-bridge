package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private GameStatus gameStatus = GameStatus.PROGRESS;

    private int position;

    private int retryCount;

    private final Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        retryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public SquareResult move(Square userMove) {
        boolean movable = bridge.canMoveForward(userMove, position);
        if (movable) {
            position ++;
        }
        return new SquareResult(userMove, MoveResult.of(movable));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        position = 0;
        retryCount++;
    }

    public boolean isGameFinalSuccess() {
        return bridge.isEndOfBridge(position);
    }

    public boolean isGameInProgress() {
        return gameStatus.equals(GameStatus.PROGRESS);
    }

    public void exitGame() {
        gameStatus = GameStatus.EXIT;
    }

    public int getPosition() {
        return position;
    }

    public int getRetryCount() {
        return retryCount;
    }

    @Override
    public String toString() {
        return String.format("상태 : %s, 현재 위치 : %s, 재시도 횟수 : %d",
                this.gameStatus.name(),
                this.position,
                this.retryCount);
    }
}
