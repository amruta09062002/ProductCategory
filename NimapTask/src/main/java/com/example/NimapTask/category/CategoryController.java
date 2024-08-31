package com.example.NimapTask.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService catService;

    @GetMapping
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return catService.getAllCategories(page, size);
    }
    
    @PostMapping
	public String insertCategory(@RequestBody Category category) {
		return catService.insertCategory(category);
	}

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") int categoryId) {
        return catService.getCategoryById(categoryId);
    }

    @PutMapping("/{id}")
    public String updateCategory(@PathVariable("id") int categoryId, @RequestBody Category category) {
        return catService.updateCategoryById(categoryId, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable("id") int categoryId) {
        return catService.deleteCategoryById(categoryId);
    }


}
