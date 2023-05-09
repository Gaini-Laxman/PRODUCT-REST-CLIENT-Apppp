package com.klinnovations.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.klinnovations.request.Product;


@Service
public class ProductServiceImpl implements ProductService {
	
	private String REQUEST_PRODUCT_URL = "http://localhost:9090/product";

	private String GET_PRODUCT_URL = "http://localhost:9090/product/{pid}";

	@Override
	public Product RequestProduct(Product product) {
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Product> respEntity = rt.postForEntity(REQUEST_PRODUCT_URL, product, Product.class);

		Product products = respEntity.getBody();

		return product;
		
		
	}

	@Override
	public Product getProductByNum(Integer pid) {
		
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Product> respEntity = rt.getForEntity(GET_PRODUCT_URL, Product.class, pid);

		Product products = respEntity.getBody();

		return products;
		
		
	}

}
