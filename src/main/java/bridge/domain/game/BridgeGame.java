package bridge.domain.game;

import bridge.domain.bridge.BridgeSize;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeSize bridgeSize;

    private GameStatus gameStatus = GameStatus.PROGRESS;

    private int position;

    private int retryCount;

    public BridgeGame(BridgeSize bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        if (position < bridgeSize.getSize()) {
            position++;
        }
    }

    public boolean isGameSuccess() {
        return position == bridgeSize.getSize();
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

    public boolean inProgress() {
        return gameStatus.equals(GameStatus.PROGRESS);
    }

    public void exit() {
        gameStatus = GameStatus.EXIT;
    }

    public int getPosition() {
        return position;
    }
}
