package racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void name() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void fiveCharactersName() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");

    }

    @Test
    void moveForwardWhenMoreThen3() {
        Car car = new Car("pobi");
        car.moveForward(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void moveForwardWhenLessThen4() {
        Car car = new Car("pobi");
        car.moveForward(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void display() {
        Car car = new Car("pobi");
        assertThat(car.getCarInfo().getCarName()).isEqualTo("pobi");
        assertThat(car.getCarInfo().getCarPosition()).isEqualTo(0);
    }

    @Test
    void displayWhenPositionIs3() {
        Car car = new Car("pobi", 3);
        assertThat(car.getCarInfo().getCarName()).isEqualTo("pobi");
        assertThat(car.getCarInfo().getCarPosition()).isEqualTo(3);
    }

    @Test
    void moveRandom() {
        Car car = new Car("pobi", 0);
        List<Integer> numbers = List.of(4, 3, 4, 3, 4, 3);
        MovingStrategy rs = new FakeMovingStrategy(numbers);
        numbers.forEach(i -> car.moveForward(rs.generateNumber()));
        assertThat(car.getPosition()).isEqualTo(3);
    }
}