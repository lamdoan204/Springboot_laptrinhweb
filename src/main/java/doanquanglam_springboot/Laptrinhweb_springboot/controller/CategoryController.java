package doanquanglam_springboot.Laptrinhweb_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import doanquanglam_springboot.Laptrinhweb_springboot.entity.Category;
import doanquanglam_springboot.Laptrinhweb_springboot.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService = new CategoryService();

    @RequestMapping("")
    public String List(HttpServletRequest request, ModelMap model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories", list);
        return "categories/listCategories" ;
    }

    @GetMapping("/add")
    public String requestMethodName(ModelMap model) {
        return "categories/addCategories";
    }
    
    @GetMapping("/delete")
    public String getMethodName() {
        return "";
    }
      
    @GetMapping("/update")
    public String getMethodName() {
        return new String();
    }
    
    

}
