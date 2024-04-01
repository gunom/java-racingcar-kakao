package view;

import java.util.List;
import java.util.Scanner;

public class RacingGameView {

    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_TRY_NUMS = "시도할 회수는 몇회인가요?";
    public static final String RESULT = "실행 결과";
    public static final String DISPLAY_WINNER_FMT = "%s가 최종 우승했습니다.\n";

    public static String getCarNames() {
        String carNames;
        System.out.println(INPUT_CAR_NAMES);
        carNames = getInput();
        while (carNames.isEmpty()) {
            System.out.println("자동차 이름을 입력해주세요.");
            carNames = getInput();
        }
        return carNames;
    }

    public static int getTryNums() {
        int tryNum = -1;
        while (tryNum == -1) {
            tryNum = getInteger();
        }
        return tryNum;
    }

    private static Integer getInteger() {
        System.out.println(INPUT_TRY_NUMS);
        try {
            int tryNums = Integer.parseInt(getInput());
            System.out.println();
            return tryNums;
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return -1;
        }
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void displayResult() {
        System.out.println(RESULT);
    }

    public static void displayCars(List<String> positionInfos) {
        positionInfos.forEach(System.out::println);
        System.out.println();
    }

    public static void displayWinners(List<String> winnerInfos) {
        String winners = String.join(", ", winnerInfos);
        System.out.printf(DISPLAY_WINNER_FMT, winners);
    }
}
