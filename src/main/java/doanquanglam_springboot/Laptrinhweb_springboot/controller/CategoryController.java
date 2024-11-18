package doanquanglam_springboot.Laptrinhweb_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import doanquanglam_springboot.Laptrinhweb_springboot.entity.Category;
import doanquanglam_springboot.Laptrinhweb_springboot.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService = new CategoryService();

    @RequestMapping("")
    public String List(HttpServletRequest request, ModelMap model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories", list);
        return "categories/listCategories";
    }

    @GetMapping("/add")
    public String requestMethodName(ModelMap model) {
        return "categories/addCategories";
    }

    @GetMapping("/edit/{id}")
    public String getMethodName(@PathVariable("id") Integer categoryId, ModelMap model) {

        Category cate = categoryService.findByCategoryId(categoryId);
        model.addAttribute("category", cate);
        return "categories/edit";

    }
    @PostMapping("/edit/{id}")
    public String postMethodName(@PathVariable("id") Integer id, @RequestParam("categoryname") String name, @RequestParam("quantity") int quantity, @RequestParam("status") String status) {
        Category category;
        category = categoryService.findByCategoryId(id);
        int statustrue;
        if(status.equals("Active")){
            statustrue = 1;
        }else{
            statustrue = 0;
        }
        category.setCategoryName(name);
        category.setCategoryQuantity(quantity);
        category.setCategoryStatus(statustrue);
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/delete/{id}")
    public String postMethodName(@PathVariable("id") Integer id) {
        categoryService.deleteById(id);
        return "redirect:/categories";
    }
    @PostMapping("/add")
    public String postMethodName(@RequestParam("categoryname") String name, @RequestParam("quantity") int quantity, @RequestParam("status") String status) {
        Category category = new Category();
        int statustrue;
        if(status.equals("Active")){
            statustrue = 1;
        }else{
            statustrue = 0;
        }
        category.setCategoryName(name);
        category.setCategoryQuantity(quantity);
        category.setCategoryStatus(statustrue);
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }

}
