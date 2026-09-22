import java.util.ArrayList;

public class Portfolio {
    double cash;
    ArrayList<Holding> holdings;
    ArrayList<Transaction> transactions;

    Portfolio(double cash) {
        this.cash = cash;
        holdings = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    void buy(Stock stock, double quantity) {
        double cost = stock.price * quantity;

        if (cost <= cash) {
            cash = cash - cost;

            boolean found = false;

            for (Holding currentHolding : holdings) {
                if (currentHolding.stock == stock) {
                    currentHolding.quantity = currentHolding.quantity + quantity;
                    found = true;
                }
            }

            if (!found) {
                Holding holding = new Holding(stock, quantity);
                holdings.add(holding);
            }

            Transaction transaction = new Transaction("BUY", stock, quantity, stock.price);
            transactions.add(transaction);

            System.out.println("Bought " + quantity + " shares of " + stock.name);
        } else {
            System.out.println("Not enough cash to buy " + quantity + " shares of " + stock.name);
        }
    }

    void sell(Stock stock, double quantity) {

        for (int i = 0; i < holdings.size(); i++) {
            Holding currentHolding = holdings.get(i);

            if (currentHolding.stock == stock) {
                if (quantity <= currentHolding.quantity) {
                    currentHolding.quantity = currentHolding.quantity - quantity;

                    double saleValue = stock.price * quantity;
                    cash = cash + saleValue;

                    if (currentHolding.quantity == 0) {
                        holdings.remove(i);
                    }

                    Transaction transaction = new Transaction("SELL", stock, quantity, stock.price);
                    transactions.add(transaction);

                    System.out.println("Sold " + quantity + " shares of " + stock.name);
                } else {
                    System.out.println("Not enough shares to sell.");
                }
            }
        }
    }
}
