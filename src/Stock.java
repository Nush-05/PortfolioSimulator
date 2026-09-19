public class Stock {
    String name;
    String ticker;
    double price;
    double previousYearReturn;

    Stock(String name, String ticker, double price, double previousYearReturn) {
        this.name = name;
        this.ticker = ticker;
        this.price = price;
        this.previousYearReturn = previousYearReturn;
    }
}
