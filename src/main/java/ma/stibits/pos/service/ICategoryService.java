package ma.stibits.pos.service;

import ma.stibits.pos.model.bo.Category;

import java.util.List;

public interface ICategoryService {
    public Category saveCategory(Category cat);
    public List<Category> listCategories();
    Category getCategory(Long id);
    Category updateCategory(Category catt);
    public  void deleteCategory(Long id);
}
