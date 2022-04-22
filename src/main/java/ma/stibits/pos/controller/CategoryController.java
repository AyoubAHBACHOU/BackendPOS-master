package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.Account;
import ma.stibits.pos.model.bo.Category;
import ma.stibits.pos.service.Implementation.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category cat) {
        Category newCat = categoryService.saveCategory(cat);
        return new ResponseEntity<>(newCat, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public  ResponseEntity<List<Category>> listCategory(){
        List<Category> lst=categoryService.listCategories();
        return new ResponseEntity<>(lst,HttpStatus.OK);
    }


    @GetMapping(path="/getOne/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long idCat) {
        Category cat=categoryService.getCategory(idCat);
        return new ResponseEntity<>(cat,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category c){
        Category cat=categoryService.updateCategory(c);
        return  new ResponseEntity<>(cat,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCate(@PathVariable("id") Long idCat){

        categoryService.deleteCategory(idCat);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
