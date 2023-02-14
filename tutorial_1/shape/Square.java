package module1.shape;
public class Square extends Rectangle{
    public Square(double side){
        super(side, side);
    }

    public double getSide() {
        return getLength();
    }

    public void setSide(double side) {
        setLength(side);
        setWidth(side);
    }

}