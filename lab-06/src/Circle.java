public class Circle extends Shape {
    private final int r;

    public int getR() {
        return r;
    }

    Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    boolean contains(int x, int y) {
        int dx = this.x + r - x;
        int dy = this.y + r - y;
        return dx * dx + dy * dy <= r * r;
    }

    public String toString() {
        return String.format("Circle: %d, %d, %d", x, y, r);
    }

}
