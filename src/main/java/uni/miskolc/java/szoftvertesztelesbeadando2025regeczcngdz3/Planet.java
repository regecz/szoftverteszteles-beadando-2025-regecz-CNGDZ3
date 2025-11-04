package uni.miskolc.java.szoftvertesztelesbeadando2025regeczcngdz3;

public class Planet {
    private final int width;
    private final int height;
    private final boolean[][] obstacles;

    public Planet(int width, int height) {
        this.width = width;
        this.height = height;

        this.obstacles = new boolean[width + 1][height + 1];
    }

    public Planet(int width, int height, boolean[][] obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean[][] getObstacles() {
        return obstacles;
    }
}
