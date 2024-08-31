package com.example.NimapTask.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.NimapTask.Messages;
import com.example.NimapTask.category.Category;
import com.example.NimapTask.category.categoryRepository;

@Service
public class ProductService {
	
	@Autowired
	private productRepository productRepository;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private categoryRepository catRepository;

	public Page<Product> getAllProducts(int page, int size) {
		return productRepository.findAll(PageRequest.of(page, size));
	}

	public Product getProductById(int productId) {
		return productRepository.findById(productId)
                                 .orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public String insertProduct(Product product) {
		if (productDao.insertProduct(product)) {
			return Messages.prodinsertMessage();
		} else {
			return Messages.prodnotInsertMessage();
		}
	}

	public String updateProductById(int productId, Product product) {
		if (productDao.updateProductById(productId,product)) {
			return Messages.produpdatedMessage();
		} else {
			return Messages.prodnotUpdatedMessage();
		}
	}
	
	public void deleteProductById(int productId) {
		Product product = productRepository.findById(productId)
                                           .orElseThrow(() -> new RuntimeException("Product not found"));
		productRepository.delete(product);
	}
}
