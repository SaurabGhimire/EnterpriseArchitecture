package customers;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements  ProductRepository{
    Logger logger;

    ProductRepositoryImpl(Logger logger){
        this.logger = logger;
    }
    @Override
    public void save(Product product) {
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ProductRepository: saving product "+product.getName());
        logger.log("Product is saved in the DB: "+ product.getName() );
    }
}
