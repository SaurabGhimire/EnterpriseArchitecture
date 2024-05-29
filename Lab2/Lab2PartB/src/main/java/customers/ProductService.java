package customers;

public interface ProductService {
    void addProduct(String name, double price, String category, String email);

    void setProductRepository(ProductRepository ProductRepository);

    void setEmailSender(EmailSender emailSender) ;
}
