package doanquanglam_springboot.Laptrinhweb_springboot.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
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
}
