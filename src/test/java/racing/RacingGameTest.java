package racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void commaSeperatedCarNames() {
        RacingGame racingGame = new RacingGame("pobi,crong,honux", 5);
        List<Car> cars = racingGame.getCars();
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("crong");
        assertThat(cars.get(2).getName()).isEqualTo("honux");
    }

    @Test
    void winner() {
        RacingGame racingGame = new RacingGame(
                List.of(new Car("pobi", 4),
                new Car("crong", 5),
                new Car("honux", 5)), 5);

        List<String> winners = racingGame.getWinners();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("crong");
        assertThat(winners.get(1)).isEqualTo("honux");
    }
}