package com.product.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.product.entity.Product;
import com.product.service.ProductService;

@Controller
@RequestMapping("/prod")
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	//List all product details
	@GetMapping("/showprod")
	public String desplayProd(Model model) {
		List<Product> prod =  service.findAll();
		model.addAttribute("PRODUCT",prod);
		
		return "prodUI/products.html";
	}
	
	


	@GetMapping("/addProd")
	public String prodForm(Model model) {
		model.addAttribute("PRODUCT", new Product());
		return "prodUI/productForm.html";
		
	}
	
	//Add new product
	@PostMapping("/save")
	public String save(@ModelAttribute("PRODUCT") Product prod) {
		service.save(prod);
		return "redirect:/prod/showprod";
	}

	
	//Update product
	@GetMapping("updateProd")
	public String updateForm(@RequestParam ("prodId")Integer id, Model model) {
		Product prod =  service.findById(id);
		model.addAttribute("PRODUCT", prod);
		return "prodUI/productForm.html";
	}

	//delete a product by id
	@GetMapping("/delete")
		public String deleteById(@RequestParam("prodId") Integer prodId) {
			service.deleteById(prodId);
			return "redirect:/prod/showprod";
	}
	
	
	@GetMapping("/search")
	public String search(@RequestParam("sku") String sku,Model model) { 
		List<Product> products = service.searchBy(sku);
		model.addAttribute("PRODUCT",products);
		return "prodUI/products.html";
	}
}
