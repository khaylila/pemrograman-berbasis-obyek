import bentuk.*;

public class App {
    public static void main(String[] args) {
        // membuat objek dari class Triangle
        Triangle segitiga = new Triangle(3, 3);

        // membuat objek dari class Circle
        Circle lingkaran = new Circle(6);

        System.out.println("Luas Segitiga: " + segitiga.getArea());
        System.out.println("Luas Lingkaran: " + lingkaran.getArea());
    }
}
