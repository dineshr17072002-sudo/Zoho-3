package stockManagement;

public class Product {

    String productId;
    String productName;
    String category;
    int quantity;
    double price;
    String supplier;

    public Product(String productId, String productName, String category,
                   int quantity, double price, String supplier) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product ID : " + productId +
                "\nName : " + productName +
                "\nCategory : " + category +
                "\nQuantity : " + quantity +
                "\nPrice : " + price +
                "\nSupplier : " + supplier;
    }
}