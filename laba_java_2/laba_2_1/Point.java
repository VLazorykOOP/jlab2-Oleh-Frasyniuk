import java.util.Objects;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void moveX(double deltaX) {
        this.x += deltaX;
    }

    // Переміщення вздовж осі y
    public void moveY(double deltaY) {
        this.y += deltaY;
    }

    //відстані до початку координат
    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    //відстані між двома точками
    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Перетворення до полярних координат
    public double[] toPolarCoordinates() {
        double r = Math.sqrt(x * x + y * y); // Радіус
        double theta = Math.atan2(y, x);    // Кут (в радіанах)
        return new double[]{r, theta};
    }

    // Порівняння на співпадання
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    // Порівняння на неспівпадання
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // Представлення точки у вигляді рядка
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(6, 8);

        System.out.println("P1: " + p1);
        System.out.println("P2: " + p2);

        // Переміщення точки
        p1.moveX(2);
        p1.moveY(-1);
        System.out.println("p1 after move: " + p1);

        // Відстань до початку координат
        System.out.println("Distance P1 to start coordinate: " + p1.distanceToOrigin());

        // Відстань між двома точками
        System.out.println("Distance p1 between p2: " + p1.distanceTo(p2));

        // Полярні координати
        double[] polar = p1.toPolarCoordinates();
        System.out.println("Polar coordinates p1: r = " + polar[0] + ", θ = " + polar[1]);

        // Порівняння точок
        System.out.println("p1 i p2 similar: " + p1.equals(p2));
    }
}
