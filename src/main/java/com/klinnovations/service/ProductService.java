package com.klinnovations.service;

import com.klinnovations.request.Product;

public interface ProductService {

	public Product RequestProduct(Product product);

	public Product getProductByNum(Integer pid);

}
