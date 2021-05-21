public abstract class Shape {
    protected int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;
    }
    abstract boolean contains(int x, int y);


}
