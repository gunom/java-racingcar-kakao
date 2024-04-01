package controller;

import racing.RacingGame;
import view.RacingGameView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGameController {

    public  void startGame() {
        RacingGame racingGame = setup();
        playround(racingGame);
        result(racingGame);
    }

    private RacingGame setup() {
        String carNames = RacingGameView.getCarNames();
        while (carNames.isEmpty()) {
            carNames = RacingGameView.getCarNames();
        }
        int tryNums = RacingGameView.getTryNums();
        return new RacingGame(carNames, tryNums);
    }

    private  void playround(RacingGame racingGame) {
        RacingGameView.displayResult();
        RacingGameView.displayCars(racingGame.getCarsPositionInfos());
        IntStream.range(0, racingGame.getTryNums()).forEach(i -> {
            racingGame.moveCars();
            RacingGameView.displayCars(racingGame.getCarsPositionInfos());
        });
    }

    private  void result(RacingGame racingGame) {
        List<String> winners = racingGame.getWinners();
        RacingGameView.displayWinners(winners);
    }
}
