package racing;

public class CarInfo {
    private final String carName;
    private final int carPosition;

    public CarInfo(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition + 1;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
