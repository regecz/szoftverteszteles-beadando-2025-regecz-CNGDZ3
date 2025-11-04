package uni.miskolc.java.szoftvertesztelesbeadando2025regeczcngdz3;

public class Rover {
    private final Planet planet;
    private Position position;
    private Direction direction;

    public Rover(Planet planet, Position start, Direction facing) {
        this.planet = planet;
        this.position = start;
        this.direction = facing;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}

