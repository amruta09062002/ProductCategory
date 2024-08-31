package com.example.NimapTask.product;

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

import com.example.NimapTask.category.Category;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
    private ProductService productService;

	@GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page, 
                                        @RequestParam(defaultValue = "10") int size) {
        return productService.getAllProducts(page, size);
    }

	@PostMapping
	public String insertProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") int productId) {
		return productService.getProductById(productId);
	}

	@PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") int productId, @RequestBody Product product) {
        return productService.updateProductById(productId, product);
    }

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") int productId) {
		productService.deleteProductById(productId);
	}

}
