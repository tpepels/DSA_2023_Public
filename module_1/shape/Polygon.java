package module_1.shape;

public abstract class Polygon implements Shape {
    private double numberOfSides;

    public Polygon(double numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public double getNumberOfSides() {
        return numberOfSides;
    }
}
