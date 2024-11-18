package doanquanglam_springboot.Laptrinhweb_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import doanquanglam_springboot.Laptrinhweb_springboot.entity.Category;
import doanquanglam_springboot.Laptrinhweb_springboot.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> findAll() {

        return categoryRepo.findAll();

    }
    public Category findByCategoryId(Integer id){
       return categoryRepo.findByCategoryId(id);
    }
    public void updateCategory(Category category){
        categoryRepo.save(category);
    }
    public void deleteById(int id){
        categoryRepo.deleteById(id);
    }
    public Page<Category> findCategories(String searchKeyword, Pageable pageable) {
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            return categoryRepo.findByCategoryNameContaining(searchKeyword, pageable);
        } else {
            return categoryRepo.findAll(pageable);  // Nếu không tìm kiếm, lấy tất cả
        }
    }
}
