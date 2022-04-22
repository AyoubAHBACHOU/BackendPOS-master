package ma.stibits.pos.service;

import ma.stibits.pos.model.bo.Category;
import ma.stibits.pos.model.bo.Product;

import java.util.List;

public interface IProductService {
    public Product saveProduct(Product cat);
    public List<Product> listProducts();
    Product getProduct(Long id);
    Product updateProduct(Product catt);
    public  void deleteProduct(Long id);
}
