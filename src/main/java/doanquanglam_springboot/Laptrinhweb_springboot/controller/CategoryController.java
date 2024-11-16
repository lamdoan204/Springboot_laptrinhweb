package doanquanglam_springboot.Laptrinhweb_springboot.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import doanquanglam_springboot.Laptrinhweb_springboot.entity.Category;
import doanquanglam_springboot.Laptrinhweb_springboot.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService = new CategoryService();

    @RequestMapping("")
    public String List(ModelMap model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories", list);
        return "/templates/categories/listCategories";
    }

}
