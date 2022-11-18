package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String REG_XP_DIGIT = "[0-9]+";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String size = Console.readLine();
        isBridgeSizeDigit(size);
        return Integer.parseInt(size);
    }

    private void isBridgeSizeDigit(String length) {
        if (!length.matches(REG_XP_DIGIT)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력 가능합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
