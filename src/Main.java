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

        Holding appleHolding = new Holding(apple, 2.5);
        portfolio.holdings.add(appleHolding);

        Holding microsoftHolding = new Holding(microsoft, 1.5);
        portfolio.holdings.add(microsoftHolding);

        Holding nvidiaHolding = new Holding(nvidia, 3.0);
        portfolio.holdings.add(nvidiaHolding);

        System.out.println();
        System.out.println("Number of Holdings: " + portfolio.holdings.size());
        for (int i=0; i< portfolio.holdings.size(); i++){
            Holding currentHolding = portfolio.holdings.get(i);

            System.out.println("Stock: " + currentHolding.stock.name);
            System.out.println("Shares: " + currentHolding.quantity);
        }

        System.out.println();
        System.out.println("Portfolio Cash: £" + portfolio.cash);



    }
}