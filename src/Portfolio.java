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

        cash = cash - cost;

        Holding holding = new Holding(stock, quantity);
        holdings.add(holding);
    }
}
