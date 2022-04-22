package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.Product;
import ma.stibits.pos.service.Implementation.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unbescape.html.HtmlEscape;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product c)
    {
        Product p=productService.saveProduct(c);
        return new ResponseEntity<>(p,HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> lst=productService.listProducts();
        return new ResponseEntity<>(lst,HttpStatus.OK);}

    @GetMapping(path="/getOne/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long idPro) {
        Product p=productService.getProduct(idPro);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product c){
        Product p=productService.updateProduct(c);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePro(@PathVariable("id") Long idPro){
        productService.deleteProduct(idPro);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
