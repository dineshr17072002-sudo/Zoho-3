package stockManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();

        while (true) {

            System.out.println("\n===== STOCK MANAGEMENT =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Search By ID");
            System.out.println("4. Search By Name");
            System.out.println("5. Search By Category");
            System.out.println("6. Update Product");
            System.out.println("7. Low Stock Report");
            System.out.println("8. Sales Report");
            System.out.println("9. Purchase Report");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
//
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Supplier: ");
                    String supplier = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    Product product = new Product(id, name, category, quantity, price, supplier);
                    inv.addProduct(product);
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    id = sc.nextLine();

                    System.out.print("Enter Quantity (+Purchase / -Sale): ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    inv.updateStock(id, qty);
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    id = sc.nextLine();
                    inv.searchById(id);
                    break;

                case 4:
                    System.out.print("Enter Product Name: ");
                    name = sc.nextLine();
                    inv.searchByName(name);
                    break;

                case 5:
                    System.out.print("Enter Category: ");
                    category = sc.nextLine();
                    inv.searchByCategory(category);
                    break;

                case 6:
                    System.out.print("Enter Product ID: ");
                    id = sc.nextLine();

                    System.out.print("Enter New Product Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter New Category: ");
                    category = sc.nextLine();

                    System.out.print("Enter New Supplier: ");
                    supplier = sc.nextLine();

                    System.out.print("Enter New Price: ");
                    price = sc.nextDouble();
                    sc.nextLine();

                    inv.updateProduct(id, name, category, supplier, price);
                    break;

                case 7:
                    System.out.print("Enter Threshold: ");
                    int threshold = sc.nextInt();
                    sc.nextLine();

                    inv.lowStockReport(threshold);
                    break;

                case 8:
                    inv.salesReport();
                    break;

                case 9:
                    inv.purchaseReport();
                    break;

                case 10:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}