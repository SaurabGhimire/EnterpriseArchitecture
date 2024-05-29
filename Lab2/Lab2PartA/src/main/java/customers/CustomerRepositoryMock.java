package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public class CustomerRepositoryMock implements  CustomerRepository{
    private Logger logger ;

    @Autowired
    CustomerRepositoryMock(Logger logger){
        this.logger = logger;
    }

    public void save(Customer customer) {
        // simple sleep
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CustomerRepositoryMock: saving customer "+customer.getName());
        logger.log("Customer is saved in the DB: "+ customer.getName() );
    }
}
