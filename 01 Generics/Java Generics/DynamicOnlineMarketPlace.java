import java.util.ArrayList;
import java.util.List;

abstract class Product<T>{
    private T productname;

    public Product(T productname) {
        this.productname = productname;
    }

    public T getProductname() {
        return productname;
    }

    abstract public void displayDetails();
}

class Books extends Product{
    private String Author;

    public Books(Object productname, String author) {
        super(productname);
        Author = author;
    }

    public String getAuthor() {
        return Author;
    }

    @Override
    public void displayDetails() {
        System.out.println("Product Name : "+getProductname());
        System.out.println("Author Name : "+Author);
    }
}

class Clothing extends Product{
    private double price;

    public Clothing(Object productname, double price) {
        super(productname);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void applydiscount(double percentage){
        this.price-=price*(percentage/100.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("Product Name : "+getProductname());
        System.out.println("Price : "+price);
    }
}

class Gadgets extends Product{
    private String Model;

    public Gadgets(Object productname, String model) {
        super(productname);
        Model = model;
    }

    public String getModel() {
        return Model;
    }

    @Override
    public void displayDetails() {
        System.out.println("Product Name : "+getProductname());
        System.out.println("Model name : "+Model);
    }
}

class Catalog<T extends Product<?>>{
    private List<T> productlist=new ArrayList<>();

    public void addProduct(T item){
        productlist.add(item);
    }

    public List<T> getProductlist() {
        return productlist;
    }

    public void showallProduct(){
        for (T product:productlist){
            product.displayDetails();
            System.out.println();
        }
    }
}
public class DynamicOnlineMarketPlace {
    public static <T extends Product> void applyDiscount(T product, double percentage){
        if (product instanceof Clothing){
            ((Clothing) product).applydiscount(percentage);
            System.out.println("Discount Applied of percentage :"+percentage);
        }
        else{
            System.out.println("Discount not applicable");
        }
    }

    public static void main(String[] args) {
        Catalog<Product<?>> catalog=new Catalog<>();

        Clothing c1=new Clothing("T-shirt", 799.99);
        catalog.addProduct(new Books("The Alchemist", "Paulo Coelho"));
        catalog.addProduct(c1);
        catalog.addProduct(new Gadgets("Smartphone","Galaxy S24"));

        System.out.println("All products in the Catelog:\n");
        catalog.showallProduct();

        System.out.println("\nApplying discount...");
        applyDiscount(new Clothing("T-shirt", 799.99), 20); // Only Clothing gets discount
        System.out.println();

        System.out.println("Updated Product List:\n");
        catalog.showallProduct();
    }

}
