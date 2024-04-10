package com.example.productservicesst.Service;

import com.example.productservicesst.Models.Product;

import java.util.List;


public interface ProductService {

    Product getProductById(Long id);

//    List<Product> getAllProducts();

    List<Product> getAllProducts();

}
