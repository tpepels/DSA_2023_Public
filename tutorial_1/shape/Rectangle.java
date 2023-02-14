package module1.shape;
public class Rectangle extends Polygon{
    private double width;
    private double length;

    public Rectangle(double width, double length){
        super(4);
        this.width = width;
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double computeArea(){
        return length * width;
    }

    @Override
    public double computePeremeter(){
        return 2*(length + width);
    }

}
