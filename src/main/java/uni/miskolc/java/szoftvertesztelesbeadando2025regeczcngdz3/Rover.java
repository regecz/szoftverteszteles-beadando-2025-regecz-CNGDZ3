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
                    if (position.getY() >= planet.getHeight()) {
                        position = new Position(position.getX(), 0);
                        continue;
                    }
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (direction == Direction.S) {
                    if (position.getY() <= 0) {
                        position = new Position(position.getX(), planet.getHeight());
                        continue;
                    }
                    position = new Position(position.getX(), position.getY() - 1);
                } else if (direction == Direction.E) {
                    if (position.getX() >= planet.getWidth()) {
                        position = new Position(0, position.getY());
                        continue;
                    }
                    position = new Position(position.getX() + 1, position.getY());
                } else if (direction == Direction.W) {
                    if (position.getX() <= 0) {
                        position = new Position(planet.getWidth(), position.getY());
                        continue;
                    }
                    position = new Position(position.getX() - 1, position.getY());
                }
            }

            if (c == 'b') {
                if (direction == Direction.N) {
                    if (position.getY() <= 0) {
                        position = new Position(position.getX(), planet.getHeight());
                        continue;
                    }
                    position = new Position(position.getX(), position.getY() - 1);
                } else if (direction == Direction.S) {
                    if (position.getY() >= planet.getHeight()) {
                        position = new Position(position.getX(), 0);
                        continue;
                    }
                    position = new Position(position.getX(), position.getY() + 1);
                }  else if (direction == Direction.E) {
                    if (position.getX() <= 0) {
                        position = new Position(planet.getWidth(), position.getY());
                        continue;
                    }
                    position = new Position(position.getX() - 1, position.getY());
                }   else if (direction == Direction.W) {
                    if (position.getX() >= planet.getWidth()) {
                        position = new Position(0, position.getY());
                        continue;
                    }
                    position = new Position(position.getX() + 1, position.getY());
                }
            }

            if (c == 'r') {
                if (direction == Direction.N) {
                    direction = Direction.E;
                } else if (direction == Direction.E) {
                    direction = Direction.S;
                } else if (direction == Direction.S) {
                    direction = Direction.W;
                } else if (direction == Direction.W) {
                    direction = Direction.N;
                }
            }

            if (c == 'l') {
                if (direction == Direction.N) {
                    direction = Direction.W;
                    continue;
                }
                if (direction == Direction.W) {
                    direction = Direction.S;
                    continue;
                }
            }
        }
    }
}
