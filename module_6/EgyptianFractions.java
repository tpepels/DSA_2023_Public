public class EgyptianFractions {
    public static void printEgyptianFraction(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return;
        }
        
        // If the fraction is already a unit fraction
        if (denominator % numerator == 0) {
            System.out.println("1/" + denominator / numerator);
            return;
        }
        
        // If numerator divides denominator, then simple division makes the fraction in 1/n form
        if (numerator % denominator == 0) {
            System.out.println(numerator / denominator);
            return;
        }
        
        // If numerator is more than denominator
        if (numerator > denominator) {
            System.out.print(numerator / denominator + " + ");
            printEgyptianFraction(numerator % denominator, denominator);
            return;
        }
        
        // We reach here if denominator is greater than numerator and numerator is not 1.
        int n = denominator / numerator + 1;
        System.out.print("1/" + n + " + ");
        
        // Call the function recursively for the remaining part
        printEgyptianFraction(numerator * n - denominator, denominator * n);
    }
    
    public static void main(String[] args) {
        int numerator = 6, denominator = 14;
        System.out.print("Egyptian Fraction Representation of " + numerator + "/" + denominator + " is: ");
        printEgyptianFraction(numerator, denominator);
    }
}
