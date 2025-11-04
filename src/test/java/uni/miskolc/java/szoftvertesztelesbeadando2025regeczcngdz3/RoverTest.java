package uni.miskolc.java.szoftvertesztelesbeadando2025regeczcngdz3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    //Movement tests for forward
    @Test
    void initializesWithGivenPositionAndDirection() {
        Planet planet = new Planet(10, 10);
        Rover rover = new Rover(planet, new Position(3, 4), Direction.N);

        assertEquals(3, rover.getPosition().getX());
        assertEquals(4, rover.getPosition().getY());
        assertEquals(Direction.N, rover.getDirection());
    }
    @Test
    void executesForwardFacingNorthMovesUpOne() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.N);

        rover.execute("f");

        assertEquals(0, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals(Direction.N, rover.getDirection());
    }



    @Test
    void executesForwardFacingSouthMovesDownOne() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(2, 2), Direction.S);

        rover.execute("f");

        assertEquals(2, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    void executesForwardFacingEastMovesRightOne() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.E);

        rover.execute("f");

        assertEquals(1, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void executesForwardFacingWestMovesLeftOne() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(2, 2), Direction.W);

        rover.execute("f");

        assertEquals(1, rover.getPosition().getX());
        assertEquals(2, rover.getPosition().getY());
        assertEquals(Direction.W, rover.getDirection());
    }

    //Movement tests for backward
    @Test
    void executesBackwardFacingNorthMovesDownOne() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 1), Direction.N);

        rover.execute("b");

        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    void executesBackwardFacingSouthMovesUpOne() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.S);

        rover.execute("b");

        assertEquals(0, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    void executesBackwardFacingEastMovesLeftOne() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(5, 5), Direction.E);

        rover.execute("b");

        assertEquals(4, rover.getPosition().getX());
        assertEquals(5, rover.getPosition().getY());
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void executesBackwardFacingWestMovesRightOne() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(5, 5), Direction.W);

        rover.execute("b");

        assertEquals(6, rover.getPosition().getX());
        assertEquals(5, rover.getPosition().getY());
        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    void executesTurningRightFromNorthToEast() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.N);

        rover.execute("r");

        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void executesTurningRightFromEastToSouth() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.E);

        rover.execute("r");

        assertEquals(Direction.S, rover.getDirection());
    }
}
