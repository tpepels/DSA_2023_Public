package module_1.basic_recursion;

public class BasicRecursion {
    public static void main(String[] args) {
        try{
            // System.out.println(factorial(5));
            System.out.println(fibonacci(50));
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Sorry!");
        }
        
    }

    public static double factorial(int n) throws Exception{
        if(n<1){
            throw new Exception("n should be positive");
        }
        if(n==1){
            return 1;
        }
        return n* factorial(n-1);
    }

    public static double fibonacci(int n) throws Exception{
        if(n<0){
            throw new Exception("n should be positive");
        }
        if((n==0) || (n==1)){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
