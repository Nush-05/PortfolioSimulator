public class Main {
    public static void main(String[] args) {
        System.out.println("Portfolio Simulator");

        Stock apple = new Stock("Apple", "AAPL", 220.00, 12.4);
        Stock microsoft = new Stock("Microsoft", "MSFT", 500.00, 18.2);
        Stock nvidia = new Stock("NVIDIA", "NVDA", 180.00, 25.6);

        System.out.println("Stock: " + apple.name);
        System.out.println("Ticker: " + apple.ticker);
        System.out.println("Price: £" + apple.price);
        System.out.println("Previous Year Return: " + apple.previousYearReturn + "%");

        System.out.println();
        System.out.println("Stock: " + microsoft.name);
        System.out.println("Ticker: " + microsoft.ticker);
        System.out.println("Price: £" + microsoft.price);
        System.out.println("Previous Year Return: " + microsoft.previousYearReturn + "%");

        System.out.println();
        System.out.println("Stock: " + nvidia.name);
        System.out.println("Ticker: " + nvidia.ticker);
        System.out.println("Price: £" + nvidia.price);
        System.out.println("Previous Year Return: " + nvidia.previousYearReturn + "%");

        Portfolio portfolio = new Portfolio(10000.00);

        portfolio.buy(apple, 2.5);
        portfolio.buy(apple, 1.5);
        portfolio.buy(microsoft, 1.5);
        portfolio.buy(nvidia, 3.0);

        portfolio.sell(apple, 1.5);

        apple.updatePrice(240.00);

        System.out.println();
        System.out.println("Number of Holdings: " + portfolio.holdings.size());

        double totalHoldingsValue = 0;
        for (int i=0; i< portfolio.holdings.size(); i++){
            Holding currentHolding = portfolio.holdings.get(i);

            double value = currentHolding.stock.price * currentHolding.quantity;

            totalHoldingsValue = totalHoldingsValue + value;

            System.out.println("Stock: " + currentHolding.stock.name);
            System.out.println("Shares: " + currentHolding.quantity);
            System.out.println("Value: £" + value);
        }

        double totalPortfolioValue = portfolio.cash + totalHoldingsValue;
        double profitLoss = totalPortfolioValue - portfolio.startingCash;

        System.out.println();
        System.out.println("Total Holdings Value: £" + totalHoldingsValue);
        System.out.println("Total Portfolio Value: £" + totalPortfolioValue);
        System.out.println("Portfolio Cash: £" + portfolio.cash);
        System.out.println("Profit/Loss: £" + profitLoss);
        System.out.println();

        System.out.println();
        System.out.println("Transaction History:");

        double totalBought = 0;
        double totalSold = 0;
        for (Transaction transaction : portfolio.transactions) {
            double transactionValue = transaction.quantity * transaction.price;

            if (transaction.type.equals("BUY")){
                totalBought = totalBought + transactionValue;
            }

            if (transaction.type.equals("SELL")){
                totalSold = totalSold + transactionValue;
            }

            System.out.println(transaction.type + " "
                    + transaction.stock.name + " "
                    + transaction.quantity + " shares at £"
                    + transaction.price);
        }

        System.out.println();
        System.out.println("Total Bought: £" + totalBought);
        System.out.println("Total Sold: £" + totalSold);



    }
}