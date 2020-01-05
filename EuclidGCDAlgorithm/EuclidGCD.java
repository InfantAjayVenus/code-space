public class EuclidGCD {
    
    static int getGCD(int numerator, int denominator) {

        //Swap if numerator is smaller than denominator
        if(denominator > numerator){
            int temp = numerator;
            numerator = denominator;
            denominator = temp;
        }

        while (denominator > 0) {
            int reminder = numerator % denominator;
            numerator = denominator;
            denominator = reminder;
        }

        return numerator;
    }

    public static void main(String[] args) {
        System.out.println("Running GCD TEST");
        System.out.println("GCD(6,4) => " + EuclidGCD.getGCD(6,4));
        System.out.println("GCD(4,6) => " + EuclidGCD.getGCD(4,6));
        System.out.println("GCD(2024, 125) => "+ EuclidGCD.getGCD(2024, 125));
    }
}