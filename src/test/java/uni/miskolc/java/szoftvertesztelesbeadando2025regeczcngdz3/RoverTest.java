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
    //Movement tests for backward
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
        Rover rover = new Rover(planet, new Position(2, 2), Direction.W);

        rover.execute("b");

        assertEquals(3, rover.getPosition().getX());
        assertEquals(2, rover.getPosition().getY());
        assertEquals(Direction.W, rover.getDirection());
    }
    //Turning tests
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

    @Test
    void executesTurningRightFromSouthToWest() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.S);

        rover.execute("r");

        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    void executesTurningRightFromWestToNorth() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.W);

        rover.execute("r");

        assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    void executesTurningLeftFromNorthToWest() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.N);

        rover.execute("l");

        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    void executesTurningLeftFromWestToSouth() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.W);

        rover.execute("l");

        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    void executesTurningLeftFromSouthToEast() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.S);

        rover.execute("l");

        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void executesTurningLeftFromEastToNorth() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.E);

        rover.execute("l");

        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.N, rover.getDirection());
    }

    //Planet edge tests
    @Test
    void executesForwardAtNorthWarpToBottom() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(2, 5), Direction.N);

        rover.execute("f");

        assertEquals(2, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.N, rover.getDirection());
    }
    @Test
    void executesForwardAtSouthWarpToTop() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(2, 0), Direction.S);

        rover.execute("f");

        assertEquals(2, rover.getPosition().getX());
        assertEquals(5, rover.getPosition().getY());
        assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    void executesForwardAtEastWarpToWest() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(5, 0), Direction.E);

        rover.execute("f");

        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void executesForwardAtWestWarpToEast() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.W);

        rover.execute("f");

        assertEquals(5, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    void executesBackwardAtNorthWarpToBottom() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(2, 5), Direction.S);

        rover.execute("b");

        assertEquals(2, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    void executesBackwardAtSouthWarpToTop() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(2, 0), Direction.N);

        rover.execute("b");

        assertEquals(2, rover.getPosition().getX());
        assertEquals(5, rover.getPosition().getY());
        assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    void executesBackwardAtEastWarpToWest() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(5, 0), Direction.W);

        rover.execute("b");

        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    void executesBackwardAtWestWarpToEast() {
        Planet planet = new Planet(5, 5);
        Rover rover = new Rover(planet, new Position(0, 0), Direction.E);

        rover.execute("b");

        assertEquals(5, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void stopsAtObstacleWhenMovingForward() {
        Planet planet = new Planet(5, 5);
        planet.getObstacles()[0][1] = true;
        Rover rover = new Rover(planet, new Position(0, 0), Direction.N);

        rover.execute("f");

        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.N, rover.getDirection());
    }
}
