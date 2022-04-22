package ma.stibits.pos.service.Implementation;

import ma.stibits.pos.model.bo.Product;
import ma.stibits.pos.model.dao.ProductRepository;
import ma.stibits.pos.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product cat) {
        return productRepository.save(cat);
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll() ;
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
