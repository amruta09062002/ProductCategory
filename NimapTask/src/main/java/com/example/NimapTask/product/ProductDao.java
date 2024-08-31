package com.example.NimapTask.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.NimapTask.category.Category;

@Repository
public class ProductDao {
	
	@Autowired
	private SessionFactory factory;

	public boolean insertProduct(Product product) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			return true;
		}
	}

	public boolean updateProductById(int productId, Product updateProduct) {
		Transaction transaction = null;
		Product product = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			product = session.get(Product.class, productId);
			if (product != null) {
				Category category = session.get(Category.class, updateProduct.getCategory().getCategoryId());
				product.setProductName(updateProduct.getProductName());
				product.setProductPrice(updateProduct.getProductPrice());
				product.setProductStock(updateProduct.getProductStock());
				product.setCategory(category);
				session.update(product);
			}
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			return true;
		}
	}

}
