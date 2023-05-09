package com.klinnovations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.klinnovations.request.Product;
import com.klinnovations.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/get-product")
	public String getTicketForm(@RequestParam  Integer pid, Model model) {
		
	    Product productByNum = service.getProductByNum(pid);
		model.addAttribute("product",  productByNum);
	
		return "product-form";
	
	}
	
	@GetMapping("/product")
	public String getProductForm(Model model) {
		model.addAttribute("product", new Product());
		
		return "product-form";
		
	}
	 
	@PostMapping("/request-product")
	public String requestProduct(@ModelAttribute("product")  Product product, Model model) {
		model.addAttribute("product", new Product());
		Product products = service.RequestProduct(product);
		//System.out.println(passenger);
		model.addAttribute("msg", "Your Product Booked With Id :"+product.getPid());
		return "index";
		
		
	}
	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		
		
		return "index";
		
	}


}
