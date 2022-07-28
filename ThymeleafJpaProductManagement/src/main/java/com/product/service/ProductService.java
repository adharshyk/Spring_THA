package com.product.service;

import java.util.List;

import com.product.entity.Product;

public interface ProductService {

	public List<Product> findAll();

	public void save(Product prod);

	public Product findById(Integer id);

	public void deleteById(Integer prodId);

	public List<Product> searchBy(String sku);
	
	

//	public Product findById(Integer prodId);
//
//	public void saveOrUpdate(Product p);
//
//	public void delete(Integer prodId);

}
