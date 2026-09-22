public class Transaction {
    String type;
    Stock stock;
    double quantity;
    double price;

    Transaction(String type, Stock stock, double quantity, double price) {
        this.type = type;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
    }
}
