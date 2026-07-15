package stockManagement;

public class Transaction {

    String transactionId;
    String productId;
    String type;
    int quantity;
    String date;

    public Transaction(String transactionId,
                       String productId,
                       String type,
                       int quantity,
                       String date) {

        this.transactionId = transactionId;
        this.productId = productId;
        this.type = type;
        this.quantity = quantity;
        this.date = date;
    }

    @Override
    public String toString() {

        return transactionId + " | " +
                productId + " | " +
                type + " | " +
                quantity + " | " +
                date;
    }
}