package com.demo.service;
import com.demo.dao.*;
import com.demo.beans.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class ProductServiceImpl implements ProductService {
    private ProductDao pdao;
    
	public ProductServiceImpl() {
		pdao = new ProductDaoImpl();
	}

	@Override
	public boolean addNewProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product id:");
		int pid = sc.nextInt();
		System.out.println("Enter Product name:");
		String pname = sc.next();
		System.out.println("Enter Product quantity:");
		int qty = sc.nextInt();
		System.out.println("Enter Product price:");
		double price = sc.nextDouble();
		System.out.println("Enter Product date:");
		String dt = sc.next();
		LocalDate ldt =LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Product p = new Product(pid,pname,qty,price,ldt);
		return pdao.save(p);
	}

	@Override
	public List<Product> displayAllProduct() {
		return pdao.displayAll();
	}

	@Override
	public Product findById(int id) {
		return pdao.findById(id);
	}

	@Override
	public boolean updateById(int id, int qty, double price) {
		
		return pdao.updateById(id,qty,price);
	}

	@Override
	public boolean deleteById(int id) {
	
		return pdao.deleteById(id);
	}

	@Override
	public List<Product> sortProduct() {
		return pdao.sortByPrice();
	}

	@Override
	public void closeMyConnetion() {
		pdao.closeConnection();
		
	}

}
