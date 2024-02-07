package module_1.shape;

public class Test {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(4, 5);
        System.out.println(r.computeArea());
        System.out.println(r.computePeremeter());
        System.out.println(r.getNumberOfSides());

        Square s = new Square(5);
        System.out.println(s.computeArea());
        System.out.println(s.computePeremeter());
        System.out.println(s.getNumberOfSides());

        RectangledTriangle rt = new RectangledTriangle(3, 4);
        System.out.println(rt.computeArea());
        System.out.println(rt.computePeremeter());
        System.out.println(rt.getNumberOfSides());

    }
}