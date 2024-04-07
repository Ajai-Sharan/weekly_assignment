package com.example.productservicesst.Controllers;

import com.example.productservicesst.Models.Product;
import com.example.productservicesst.Service.FakeStoreProductService;
//import com.example.productservicesst.dtos.FakeStoreProductDto;
//import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final FakeStoreProductService fakeStoreProductService;

    ProductController(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){


            return fakeStoreProductService.getProductById(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return null;
    }


}
