package module1.shape;
public class RectangledTriangle extends Polygon {
    private double side1;
    private double side2;

    public RectangledTriangle(double side1, double side2){
        super(3);
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    @Override
    public double computeArea(){
        return (side1 * side2) / 2;
    }

    @Override
    public double computePeremeter(){
        double side3 = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
        return side1 + side2 + side3;
    }
    
}
