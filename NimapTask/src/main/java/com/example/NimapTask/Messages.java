package com.example.NimapTask;

import com.example.NimapTask.product.Product;

public class Messages {
	
	private Messages() {
		
	}
	
	public static String errorMessage() {
		return "Something Went Wrong!";
	}

	public static String idNotFound() {
		return "Id not Found!";
		
	}

	public static String insertMessage() {
		return "Category added Successfully!";
	}

	public static String notInsertMessage() {
		return "Category not added...Try Again!";
	}

	public static String updatedMessage() {
		return "Category updated Successfully!";
	}

	public static String notUpdatedMessage() {
		return "Category not updated!";
	}

	public static String deleteIdMessage() {
		return "Category deleted successfully";
	}
	
	public static String notDeleteIdMessage() {
		return "Category not deleted";
	}

	public static String prodinsertMessage() {
		return "Product inserted successfully!";
	}

	public static String prodnotInsertMessage() {
		return "Product not inserted";
	}

	public static String produpdatedMessage() {
		return "Product updated Successfully!";
	}
	
	public static String prodnotUpdatedMessage() {
		return "Product not updated";
	}

}
