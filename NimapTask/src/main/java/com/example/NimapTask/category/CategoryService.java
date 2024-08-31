package com.example.NimapTask.category;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.NimapTask.Messages;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao catDao;

	@Autowired
    private categoryRepository catRepository;
	
	@Transactional
    public Page<Category> getAllCategories(int page, int size) {
        return catRepository.findAll(PageRequest.of(page, size));
    }
    
    public String insertCategory(Category category) {
		if (catDao.insertCategory(category)) {
			return Messages.insertMessage();
		} else {
			return Messages.notInsertMessage();
		}
	}

    public Category getCategoryById(int categoryId) {
        return catRepository.findById(categoryId)
                            .orElseThrow(() -> new RuntimeException("Category not found"));
    }

	public String updateCategoryById(int categoryId, Category category) {
		if (catDao.updateCategoryById(categoryId,category)) {
			return Messages.updatedMessage();
		} else {
			return Messages.notUpdatedMessage();
		}
	}

	public String deleteCategoryById(int categoriesId) {
		if(catDao.deleteCategoryById(categoriesId)) {
			return Messages.deleteIdMessage();
		}else {
			return Messages.notDeleteIdMessage();
		}
	}

}
