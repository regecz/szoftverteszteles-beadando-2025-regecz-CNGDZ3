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
            // Move forward
            if (c == 'f') {
                if (direction == Direction.N) {
                    if (position.getY() >= planet.getHeight()) {
                        position = new Position(position.getX(), 0);
                        if (obstacleDetected(position)){
                            Position positionForReport = position;
                            position = new Position(position.getX(), planet.getHeight());
                            makeReportForObstacle(positionForReport);
                            break;
                        }
                        continue;
                    }
                    position = new Position(position.getX(), position.getY() + 1);
                    if (obstacleDetected(position)){
                        Position positionForReport = position;
                        position = new Position(position.getX(), position.getY() - 1);
                        makeReportForObstacle(positionForReport);
                    }
                } else if (direction == Direction.S) {
                    if (position.getY() <= 0) {
                        position = new Position(position.getX(), planet.getHeight());
                        if (obstacleDetected(position)){
                            Position positionForReport = position;
                            position = new Position(position.getX(), 0);
                            makeReportForObstacle(positionForReport);
                            break;
                        }
                        continue;
                    }
                    position = new Position(position.getX(), position.getY() - 1);
                    if (obstacleDetected(position)){
                        Position positionForReport = position;
                        position = new Position(position.getX(), position.getY() + 1);
                        makeReportForObstacle(positionForReport);
                    }

                } else if (direction == Direction.E) {
                    if (position.getX() >= planet.getWidth()) {
                        position = new Position(0, position.getY());
                        if (obstacleDetected(position)){
                            Position positionForReport = position;
                            position = new Position(planet.getWidth(), position.getY());
                            makeReportForObstacle(positionForReport);
                            break;
                        }
                        continue;
                    }
                    position = new Position(position.getX() + 1, position.getY());
                    if (obstacleDetected(position)){
                        Position positionForReport = position;
                        position = new Position(position.getX() - 1, position.getY());
                        makeReportForObstacle(positionForReport);
                    }
                } else if (direction == Direction.W) {
                    if (position.getX() <= 0) {
                        position = new Position(planet.getWidth(), position.getY());
                        if (obstacleDetected(position)){
                            Position positionForReport = position;
                            position = new Position(0, position.getY());
                            makeReportForObstacle(positionForReport);
                            break;
                        }
                        continue;
                    }
                    position = new Position(position.getX() - 1, position.getY());
                    if (obstacleDetected(position)){
                        Position positionForReport = position;
                        position = new Position(position.getX() + 1, position.getY());
                        makeReportForObstacle(positionForReport);
                    }
                }
            }

            // Move backward (no obstacle detection)
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
            // Turn right
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
            // Turn left
            if (c == 'l') {
                if (direction == Direction.N) {
                    direction = Direction.W;
                    continue;
                }
                if (direction == Direction.W) {
                    direction = Direction.S;
                    continue;
                }
                if (direction == Direction.S) {
                    direction = Direction.E;
                    continue;
                }
                if (direction == Direction.E) {
                    direction = Direction.N;
                    continue;
                }
            }
        }
    }

    private Position wrap(Position p) {
        int x = p.getX();
        int y = p.getY();
        int maxX = planet.getWidth();
        int maxY = planet.getHeight();
        if (x < 0) x = maxX; else if (x > maxX) x = 0;
        if (y < 0) y = maxY; else if (y > maxY) y = 0;
        return new Position(x, y);
    }

    public boolean obstacleDetected(Position nextPos) {
        Position w = wrap(nextPos);
        boolean[][] obstacles = planet.getObstacles();
        return obstacles[w.getX()][w.getY()];
    }

    public void makeReportForObstacle(Position positionForReport) {
        System.out.println("Obstacle detected at position: " + positionForReport.toString());
    }
}
