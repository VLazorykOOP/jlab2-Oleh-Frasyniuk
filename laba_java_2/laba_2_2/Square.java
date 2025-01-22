import java.util.Objects;

public class Square {
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side shouldn't equal to 0.");
        }
        this.side = side;
    }

    
    public double getSide() {
        return side;
    }

    // Сеттер для сторони
    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side shouldn't equal to 0.");
        }
        this.side = side;
    }


    public double getPerimeter() {
        return 4 * side;
    }


    public double getArea() {
        return side * side;
    }

    // Обчислення довжини діагоналі
    public double getDiagonal() {
        return Math.sqrt(2) * side;
    }

    // Представлення квадрата у вигляді рядка
    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }

   
    public static void main(String[] args) {
        Square square = new Square(5);

        System.out.println("Side: " + square.getSide());
        System.out.println("Peimetr: " + square.getPerimeter());
        System.out.println("Square: " + square.getArea());
        System.out.println("Diagonal: " + square.getDiagonal());
    }
}
