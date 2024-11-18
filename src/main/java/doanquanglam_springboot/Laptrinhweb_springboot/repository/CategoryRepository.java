package doanquanglam_springboot.Laptrinhweb_springboot.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doanquanglam_springboot.Laptrinhweb_springboot.entity.Category;





@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {  
        Category findByCategoryId(Integer categoryId);
}
