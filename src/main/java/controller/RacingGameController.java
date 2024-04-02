package controller;

import racing.RacingGame;
import view.RacingGameView;

import java.util.List;

public class RacingGameController {

    public  void startGame() {
        RacingGame racingGame = setup();
        playround(racingGame);
        result(racingGame);
    }

    private RacingGame setup() {
        String carNames = RacingGameView.getCarNames();
        int tryNums = RacingGameView.getTryNums();
        return new RacingGame(carNames, tryNums);
    }

    private  void playround(RacingGame racingGame) {
        RacingGameView.displayResult();
        racingGame.playRounds().forEach(RacingGameView::displayCars);
    }

    private  void result(RacingGame racingGame) {
        List<String> winners = racingGame.getWinners();
        RacingGameView.displayWinners(winners);
    }
}
