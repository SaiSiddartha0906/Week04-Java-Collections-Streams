import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void displayDetails();
}

class Electronics extends WarehouseItem{
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronic name : "+getName()+" Brand name : "+brand);
    }
}

class Groceries extends WarehouseItem{
    private int UseBy;

    public Groceries(String name, int useBy) {
        super(name);
        UseBy = useBy;
    }

    public int getUseBy() {
        return UseBy;
    }

    public void setUseBy(int useBy) {
        UseBy = useBy;
    }

    @Override
    public void displayDetails() {
        System.out.println("Grocery Name : "+getName()+" Use by "+UseBy+" Days");
    }
}

class Furniture extends WarehouseItem{
    private String woodtype;

    public Furniture(String name, String woodtype) {
        super(name);
        this.woodtype = woodtype;
    }

    public String getWoodtype() {
        return woodtype;
    }

    public void setWoodtype(String woodtype) {
        this.woodtype = woodtype;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture name : "+getName()+" Material Used :"+woodtype);
    }
}

class Storage<T extends WarehouseItem>{
    private List<T> storagelist=new ArrayList<>();

    public List<T> getStoragelist() {
        return storagelist;
    }

    public void additems(T itemname){
        storagelist.add(itemname);
    }
}
public class WarehouseManagementSystem {

    public static void displayallitems(List<? extends WarehouseItem> items){
        for (WarehouseItem item:items){
            item.displayDetails();
        }
    }
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage=new Storage<>();
        electronicsStorage.additems(new Electronics("Laptop","Asus"));
        electronicsStorage.additems(new Electronics("Smartphone","Realme"));

        Storage<Groceries> groceriesStorage=new Storage<>();
        groceriesStorage.additems(new Groceries("Wheat",30));
        groceriesStorage.additems(new Groceries("Rice",90));

        Storage<Furniture> furnitureStorage=new Storage<>();
        furnitureStorage.additems(new Furniture("Table","Wood"));
        furnitureStorage.additems(new Furniture("Chair","Plastic"));

        displayallitems(electronicsStorage.getStoragelist());
        System.out.println();
        displayallitems(groceriesStorage.getStoragelist());
        System.out.println();
        displayallitems(furnitureStorage.getStoragelist());
    }
}
