public class FinancialForecasting {

    public static double forecast(double value, double rate, int years) {
        if (years == 0) {
            return value;
        }
        return forecast(value * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 10000;
        double growthRate = 0.10;
        int years = 5;

        double futureValue = forecast(presentValue, growthRate, years);

        System.out.println("Present Value: " + presentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.printf("Future Value: %.2f%n", futureValue);
    }
}
