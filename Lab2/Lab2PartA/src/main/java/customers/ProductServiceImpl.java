package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    EmailSender emailSender;
    @Override
    public void addProduct(String name, double price, String category, String email) {
        Product product = new Product(name, price, category);
        productRepository.save(product);
        emailSender.sendEmail(email, "Added product " + name + " as a new Product");
    }

    @Autowired
    @Override
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    @Override
    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }
}
