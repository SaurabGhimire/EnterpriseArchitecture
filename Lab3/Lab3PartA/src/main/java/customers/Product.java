package customers;

public class Product {
    int productNumber;

    String name;
    double price;

    Supplier supplier;

    Product( int productNumber, String name, double price){
        this.name = name;
        this.price = price;
        this.productNumber = productNumber;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}
