package stockManagement;

import java.time.LocalDate;
import java.util.*;

public class Inventory {

    HashMap<String, Product> products = new HashMap<>();

    ArrayList<Transaction> transactions = new ArrayList<>();

    int transactionCounter = 1;


//
    public void addProduct(Product product) {

        if(products.containsKey(product.productId)){
            System.out.println("Product already exists.");
            return;
        }

        products.put(product.productId, product);

        System.out.println("Product Added Successfully.");
    }



    public void updateStock(String id,int qty){

        Product p=products.get(id);

        if(p==null){
            System.out.println("Product not found");
            return;
        }

        if(p.quantity+qty<0){
            System.out.println("Insufficient stock");
            return;
        }

        p.quantity=qty+ p.quantity;

       // String type=qty>0?
               // "Purchase":"Sale";

        String type=" " ;
        if(qty>0){
            System.out.println("Purchase");
        }else {
            System.out.println("Sale");
        }


        transactions.add(new Transaction(
                "T"+transactionCounter++,
                id,
                type,
                Math.abs(qty),
                LocalDate.now().toString()
        ));

        System.out.println("Stock Updated");
    }



    public void searchById(String id){

        Product p=products.get(id);

        if(p==null)
            System.out.println("Not Found");
        else
            System.out.println(p);
    }


    public void searchByName(String name){

        for(Product p:products.values()){

            if(p.productName.equalsIgnoreCase(name))
                System.out.println(p);
        }
    }



    public void searchByCategory(String category){

        for(Product p:products.values()){

            if(p.category.equalsIgnoreCase(category))
                System.out.println(p);
        }
    }


    public void updateProduct(String id,
                              String name,
                              String category,
                              String supplier,
                              double price){

        Product p=products.get(id);

        if(p==null){

            System.out.println("Product not found");
            return;
        }

        p.productName=name;
        p.category=category;
        p.supplier=supplier;
        p.price=price;

        System.out.println("Updated Successfully");
    }


    public void lowStockReport(int threshold){

        for(Product p:products.values()){

            if(p.quantity<threshold)
                System.out.println(p);
        }
    }


    public void salesReport(){

        HashMap<String,Integer> map=new HashMap<>();

        for(Transaction t:transactions){

            if(t.type.equals("Sale")){

                map.put(t.productId,
                        map.getOrDefault(t.productId,0)+t.quantity);
            }
        }

        System.out.println(map);
    }



    public void purchaseReport(){

        HashMap<String,Integer> map=new HashMap<>();

        for(Transaction t:transactions){

            if(t.type.equals("Purchase")){

                map.put(t.productId,
                        map.getOrDefault(t.productId,0)+t.quantity);
            }
        }

        System.out.println(map);
    }

}
