public class Cross extends Shape {
    private final int width, height, width2, height2, x2, y2;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth2() {
        return width2;
    }

    public int getHeight2() {
        return height2;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    Cross(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.width2 = height;
        this.height2 = width;
        this.x2 = (x) - (height - width) / 2;
        this.y2 = (y) + (height - width) / 2;
    }

    boolean contains(int x, int y) {
        return (x >= this.x && x < this.x + width &&
                y >= this.y && y < this.y + height) ||
                (x >= this.x2 && x < this.x2 + width2 &&
                y >= this.y2 && y < this.y2 + height2);
    }

    public String toString() {
        return String.format("Cross: (Rectangle: %d, %d, %d, %d), (Rectangle: %d, %d, %d, %d)",
                x, y, width, height, x2, y2, width2, height2);
    }
//Cross: (Rect: 195, 575, 10, 50), (Rect: 175, 595, 50, 10)
}
