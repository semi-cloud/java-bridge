package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeSize;
import bridge.domain.Square;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printInit();
        int size = inputView.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);

        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker =  new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());

        String move = inputView.readMoving();
        int position = 0;
        Square square = new Square(position, move);
    }
}
