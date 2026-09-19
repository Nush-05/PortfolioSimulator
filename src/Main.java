public class Main {
    public static void main(String[] args) {
        System.out.println("Portfolio Simulator");

        Stock apple = new Stock("Apple", "AAPL", 220.00, 12.4);

        System.out.println("Stock: " + apple.name);
        System.out.println("Ticker: " + apple.ticker);
        System.out.println("Price: £" + apple.price);
        System.out.println("Previous Year Return: " + apple.previousYearReturn + "%");



    }
}