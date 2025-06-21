import java.util.Arrays;
import java.util.Comparator;


public class Main {

    
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int years) {
        
        if (years == 0) {
            return presentValue;
        }

        
        return calculateFutureValueRecursive(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            presentValue *= (1 + growthRate);
        }
        return presentValue;
    }

    public static void main(String[] args) {
        double presentValue = 10000;     
        double growthRate = 0.08;        
        int years = 5;                   

        
        double futureValueRecursive = calculateFutureValueRecursive(presentValue, growthRate, years);
        System.out.printf("Future Value (Recursive) after %d years: ₹%.2f%n", years, futureValueRecursive);

       
        double futureValueIterative = calculateFutureValueIterative(presentValue, growthRate, years);
        System.out.printf("Future Value (Iterative) after %d years: ₹%.2f%n", years, futureValueIterative);
    }
}
