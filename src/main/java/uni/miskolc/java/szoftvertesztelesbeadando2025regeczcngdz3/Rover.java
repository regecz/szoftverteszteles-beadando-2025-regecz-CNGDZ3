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

    public void execute(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'f') {
                if (direction == Direction.N) {
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (direction == Direction.S) {
                    position = new Position(position.getX(), position.getY() - 1);
                } else if (direction == Direction.E) {
                    position = new Position(position.getX() + 1, position.getY());
                } else if (direction == Direction.W) {
                    position = new Position(position.getX() - 1, position.getY());
                }
            }

            if (c == 'b') {
                if (direction == Direction.N) {
                    position = new Position(position.getX(), position.getY() - 1);
                }
            }
        }
    }
}
