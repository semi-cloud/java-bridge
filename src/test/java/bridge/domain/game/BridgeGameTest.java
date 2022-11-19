package bridge.domain.game;

import bridge.domain.bridge.BridgeSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        BridgeSize bridgeSize = new BridgeSize(3);
        bridgeGame = new BridgeGame(bridgeSize);
    }

    @DisplayName("다리를 건넌다면 현재 위치가 1 증가한다.")
    @Test
    void increasePosition() {
        int curPosition = bridgeGame.getPosition();

        bridgeGame.move();

        assertThat(bridgeGame.getPosition()).isEqualTo(curPosition + 1);
    }

    @DisplayName("현재 위치가 다리의 길이와 같다면 참을 반환한다.")
    @Test
    void success() {
        IntStream.range(0, 3)
                .forEach(x -> bridgeGame.move());

        boolean gameSuccess = bridgeGame.isGameSuccess();

        assertThat(gameSuccess).isTrue();
    }


    @DisplayName("재시작하는 경우 현재 위치가 0으로 초기화된다.")
    @Test
    void retryPosition() {
        bridgeGame.move();

        bridgeGame.retry();

        assertThat(bridgeGame.getPosition()).isEqualTo(0);
    }

    @DisplayName("재시작하는 경우 재시작 횟수가 1 증가한다.")
    @Test
    void retryCount() {
        int retryCount = bridgeGame.getRetryCount();
        bridgeGame.move();

        bridgeGame.retry();

        assertThat(bridgeGame.getRetryCount()).isEqualTo(retryCount + 1);
    }
}