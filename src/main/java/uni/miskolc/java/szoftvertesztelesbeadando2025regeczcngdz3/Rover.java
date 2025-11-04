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

    public Position getPosition() { return position; }
    public Direction getDirection() { return direction; }

    public void execute(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'f' || c == 'b') {
                // compute next cell with wrapping
                Position next = wrappedNext(c);
                // skip move if obstacle
                if (obstacleDetected(next)) {
                    makeReportForObstacle(next);
                    continue;
                }
                // apply move
                position = next;
                continue;
            }

            if (c == 'r') { turnRight(); continue; }
            if (c == 'l') { turnLeft(); continue; }
            // ignore unknown commands
        }
    }

    private Position wrappedNext(char move) {
        int dx = 0, dy = 0;
        switch (direction) {
            case N -> { dy = (move == 'f') ? 1 : -1; }
            case S -> { dy = (move == 'f') ? -1 : 1; }
            case E -> { dx = (move == 'f') ? 1 : -1; }
            case W -> { dx = (move == 'f') ? -1 : 1; }
        }
        Position tentative = new Position(position.getX() + dx, position.getY() + dy);
        return wrap(tentative);
    }

    private void turnRight() {
        switch (direction) {
            case N -> direction = Direction.E;
            case E -> direction = Direction.S;
            case S -> direction = Direction.W;
            case W -> direction = Direction.N;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case N -> direction = Direction.W;
            case W -> direction = Direction.S;
            case S -> direction = Direction.E;
            case E -> direction = Direction.N;
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
