package ma.stibits.pos.service.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import ma.stibits.pos.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.stibits.pos.model.bo.Category;
import ma.stibits.pos.model.dao.CategoryRepository;
@Service
@Transactional
public class CategoryService implements ICategoryService {
	 @Autowired
	 private CategoryRepository categoryRepository;
	 
	 public Category saveCategory(Category cat)
    {
       return categoryRepository.save(cat);
    }

     public List<Category> listCategories()
    {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category updateCategory(Category catt) {
        return categoryRepository.save(catt);
    }

    @Override
    public void deleteCategory(Long id) {
        Category c = categoryRepository.findById(id).get();
        categoryRepository.delete(c);

    }
}
