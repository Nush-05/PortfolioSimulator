import java.util.ArrayList;

public class Portfolio {
    double cash;
    ArrayList<Holding> holdings;

    Portfolio(double cash){
        this.cash = cash;
        holdings = new ArrayList<>();
    }
}
