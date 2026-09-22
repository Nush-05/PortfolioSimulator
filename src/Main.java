import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        boolean running = true;
        while(running) {
            System.out.println();
            System.out.println("Menu");
            System.out.println("1. View Portfolio");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println();
                System.out.println("Number of Holdings: " + portfolio.holdings.size());

                double totalHoldingsValue = 0;
                for (int i = 0; i < portfolio.holdings.size(); i++) {
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
            }
            if (choice == 2) {
                System.out.println();
                System.out.println("Select a stock:");
                System.out.println("1. Apple");
                System.out.println("2. Microsoft");
                System.out.println("3. NVIDIA");

                System.out.print("Enter your choice: ");
                int stockChoice = scanner.nextInt();
                Stock selectedStock = null;

                if (stockChoice == 1) {
                    selectedStock = apple;
                } else if (stockChoice == 2) {
                    selectedStock = microsoft;
                } else if (stockChoice == 3) {
                    selectedStock = nvidia;
                } else {
                    System.out.println("Invalid stock choice.");
                }

                if (selectedStock != null) {
                    System.out.print("Enter quantity: ");
                    double quantity = scanner.nextDouble();

                    portfolio.buy(selectedStock, quantity);
                }

            }
            if (choice == 4) {
                System.out.println("Transaction History:");

                double totalBought = 0;
                double totalSold = 0;
                for (Transaction transaction : portfolio.transactions) {
                    double transactionValue = transaction.quantity * transaction.price;

                    if (transaction.type.equals("BUY")) {
                        totalBought = totalBought + transactionValue;
                    }

                    if (transaction.type.equals("SELL")) {
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
            if (choice == 5) {
                System.out.println("Goodbye!");
                running = false;
            }
        }

        //portfolio.buy(apple, 2.5);
        //portfolio.buy(apple, 1.5);
        //portfolio.buy(microsoft, 1.5);
        //portfolio.buy(nvidia, 3.0);

        //portfolio.sell(apple, 1.5);

        apple.updatePrice(240.00);





    }
}