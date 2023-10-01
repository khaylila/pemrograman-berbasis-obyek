package bentuk;

public abstract class Shape {

    String color;

    void setColor(String color) {
        this.color = color;
    }

    String getColor() {
        return this.color;
    }

    public abstract float getArea();
}