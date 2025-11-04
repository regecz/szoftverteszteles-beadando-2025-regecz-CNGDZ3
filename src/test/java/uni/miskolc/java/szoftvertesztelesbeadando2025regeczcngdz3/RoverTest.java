package uni.miskolc.java.szoftvertesztelesbeadando2025regeczcngdz3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void initializesWithGivenPositionAndDirection() {
        Planet planet = new Planet(10, 10);
        Rover rover = new Rover(planet, new Position(3, 4), Direction.N);

        assertEquals(3, rover.getPosition().x());
        assertEquals(4, rover.getPosition().y());
        assertEquals(Direction.N, rover.getDirection());
    }
}

