package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public void save(Product prod) {
		repository.save(prod);

	}


	public Product findById(Integer id) {
		Optional<Product> p = repository.findById(id);
		Product prod = null ;
		if(p.isPresent())
			prod = p.get();
		return prod;
	}


	public void deleteById(Integer prodId) {
		repository.deleteById(prodId);
		
	}

	
	public List<Product> searchBy(String sku) {
		List<Product> results = null ;
		if(sku != null && (sku.trim().length() > 0)) {
			results = repository.findBySku(sku);
		}else {
			results = findAll();
		}
		return results;
	}

//	public Product findById(Integer prodId) {
//		return repository.findById(prodId);
//	}
//
//
//	
//	public void saveOrUpdate(Product p) {
//		repository.saveOrUpdate(p);
//		
//	}
//	
//	public void delete(Integer prodId) {
//		repository.delete(prodId);
//	}

}
