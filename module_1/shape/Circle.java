package module_1.shape;

public class Circle implements Shape {
    private double radious;

    public Circle(double radious) {
        this.radious = radious;
    }

    public double getRadious() {
        return radious;
    }

    public void setRadious(double radious) {
        this.radious = radious;
    }

    @Override
    public double computeArea() {
        return Math.PI * radious * radious;
    }

    @Override
    public double computePeremeter() {
        return 2 * Math.PI * radious;
    }
}
