package racing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final List<Car> cars;
    private final int tryNums;

    public RacingGame(List<Car> cars, int tryNums) {
        this.cars = cars;
        this.tryNums = tryNums;
    }

    public RacingGame(String carNames, int tryNums) {
        this(carNames.split(","), tryNums);
    }

    private RacingGame(String[] carNames, int tryNums) {
        this(Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList()), tryNums);
    }

    public List<String> getWinners() {
        Map<Integer, List<Car>> groupByPosition = cars.stream().collect(Collectors.groupingBy(Car::getPosition));
        int winnerPosition = getMaxPosition(groupByPosition);
        List<Car> winner =  getWinnerSortedByName(groupByPosition, winnerPosition);
        return extreactNames(winner);
    }

    private List<String> extreactNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(Map<Integer, List<Car>> groupByPosition) {
        List<Integer> positions = new ArrayList<>(groupByPosition.keySet());
        positions.sort(Collections.reverseOrder());
        return positions.get(0);
    }

    private List<Car> getWinnerSortedByName(Map<Integer, List<Car>> groupByPosition, int winnerPosition) {
        List<Car> winners = groupByPosition.get(winnerPosition);
        winners.sort(Comparator.comparing(Car::getName));
        return winners;
    }

    public List<List<CarInfo>> playRounds() {
        List<List<CarInfo>> rounds = new ArrayList<>();
        rounds.add(getCarsPositionInfos());
        IntStream.range(0, tryNums).forEach(i -> {
            moveCars();
            rounds.add(getCarsPositionInfos());
        });
        return rounds;
    }

    private void moveCars() {
        cars.forEach(car -> car.moveForward(new RandomStrategy().generateNumber()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<CarInfo> getCarsPositionInfos() {
        return cars.stream()
                .map(Car::getCarInfo)
                .collect(Collectors.toList());
    }
}
