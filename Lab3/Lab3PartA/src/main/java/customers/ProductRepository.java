package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void clearDB() {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        jdbcTemplate.update("DELETE from product",namedParameters);
    }

    public void save(Product product) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", product.getProductNumber());
        namedParameters.put("name", product.getName());
        namedParameters.put("price", product.getPrice());
        jdbcTemplate.update(
                "INSERT INTO product VALUES ( :productNumber, :name, :price)",
                namedParameters
        );

        // save supplier

        namedParameters.put("supplierName", product.getSupplier().getName());
        namedParameters.put("supplierPhone", product.getSupplier().getPhone());
        jdbcTemplate.update("INSERT INTO supplier VALUES ( :supplierName, :supplierPhone, :productNumber)",namedParameters);
    }

    public List<Product> getAllProducts(){
        List<Product> products =  jdbcTemplate.query(
                "SELECT * FROM product",
                new HashMap<String, Product>(),
                (rs, rowNum) -> new Product(
                        rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                        )
        );
        for(Product product: products){
            Supplier supplier = getSupplierForProduct(product.getProductNumber());
            product.setSupplier(supplier);
        }
        return products;
    }

    private Supplier getSupplierForProduct(int productNumber) {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productNumber", productNumber);
        return jdbcTemplate.queryForObject(
                "SELECT * FROM supplier WHERE "+
                        "productNumber = :productNumber",
                namedParameters,
                (rs, rowNum) -> new Supplier(
                        rs.getString("name"),
                        rs.getString("phone")
                )
        );
    }

    public Product getProductByProductNumber(int productNumber){
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productNumber", productNumber);
        Product product = jdbcTemplate.queryForObject(
                "SELECT * FROM product WHERE "+
                        "productNumber = :productNumber",
                namedParameters,
                (rs, rowNum) -> new Product(
                        rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
        );
        product.setSupplier(getSupplierForProduct(product.productNumber));
        return product;
    }

    public List<Product> getProductByProductName(String productName){
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("name", productName);
        List<Product> products =  jdbcTemplate.query(
                "SELECT * FROM product WHERE "+
                        "name = :name",
                namedParameters,
                (rs, rowNum) -> new Product(
                        rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
        );
        for(Product product: products){
            product.setSupplier(getSupplierForProduct(product.getProductNumber()));
        }
        return products;
    }

    public void remove(int productNumber){
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productNumber" , productNumber);
        jdbcTemplate.update(
                "DELETE FROM product WHERE "+
                "productNumber = :productNumber" ,
                namedParameters
                );
        jdbcTemplate.update(
                "DELETE FROM supplier WHERE "+
                        "productNumber = :productNumber" ,
                namedParameters
        );
    }
}
