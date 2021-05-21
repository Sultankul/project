public class Rectangle extends Shape{
    private final int width, height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    boolean contains(int x, int y) {
        return x >= this.x && x < this.x + width &&
                y >= this.y && y < this.y + height;
    }

    public String toString() {
        return String.format("Rect: %d, %d, %d, %d", x, y, width, height);
    }

}
