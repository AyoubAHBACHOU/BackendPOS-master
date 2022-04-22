package ma.stibits.pos.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.stibits.pos.model.bo.Category;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
