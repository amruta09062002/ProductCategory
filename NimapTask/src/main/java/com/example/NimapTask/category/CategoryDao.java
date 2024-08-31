package com.example.NimapTask.category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.NimapTask.Messages;

@Repository
public class CategoryDao {
	
	@Autowired
	SessionFactory factory;
	
	public boolean insertCategory(Category category) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(category);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			return true;
		}
	}

	public boolean updateCategoryById(int categoryId, Category updatecategories) {

		Transaction transaction = null;
		Category categories = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			categories = session.get(Category.class, categoryId);
			if (categories != null) {
				categories.setCategoryName(updatecategories.getCategoryName());
				session.save(categories);
			}
			transaction.commit();
			session.close();
			return true;

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		}
		return true;
	}

	public boolean deleteCategoryById(int categoryId) {
		Transaction transaction = null;
		Category categories = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			categories = session.load(Category.class, categoryId);
			session.delete(categories);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		}
		return true;
	}

}
