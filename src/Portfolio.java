import java.util.ArrayList;

public class Portfolio {
    double cash;
    ArrayList<Holding> holdings;

    Portfolio(double cash){
        this.cash = cash;
        holdings = new ArrayList<>();
    }

    void buy(Stock stock, double quantity){
        double cost = stock.price * quantity;

        if (cost <= cash) {
            cash = cash - cost;

            Holding holding = new Holding(stock, quantity);
            holdings.add(holding);

            System.out.println("Bought " + quantity + " shares of " + stock.name);
        } else {
            System.out.println("Not enough cash to buy " + quantity + " shares of " + stock.name);
        }

    }
}
