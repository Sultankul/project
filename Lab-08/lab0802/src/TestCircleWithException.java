public class TestCircleWithException {
    public static void main(String[] args) {
        try {
            CircleWithExeption c1 = new CircleWithExeption(5);
            CircleWithExeption c2 = new CircleWithExeption(-5);
            CircleWithExeption c3 = new CircleWithExeption(5);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("Number of objects created: " +
                CircleWithExeption.getNumberOfObjects());
    }
}
