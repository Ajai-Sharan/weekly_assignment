package com.example.productservicesst.Controllers;

import com.example.productservicesst.Models.Product;
import com.example.productservicesst.Service.FakeStoreProductService;
//import com.example.productservicesst.dtos.FakeStoreProductDto;
//import org.springframework.http.RequestEntity;
import com.example.productservicesst.Service.ProductService;
import com.example.productservicesst.dtos.Exceptiondtos;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

//    private final FakeStoreProductService fakeStoreProductService;
//
//    ProductController(FakeStoreProductService fakeStoreProductService){
//        this.fakeStoreProductService = fakeStoreProductService;
//    }

    private ProductService productService;

    ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){

//            throw new RuntimeException("Something went wrong in Controller");

//        ResponseEntity responseEntity;
//
//
//            try {
//
//                Product product = fakeStoreProductService.getProductById(id);
//                responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//                return responseEntity;
//            }catch (RuntimeException ex){
//                Exceptiondtos exceptiondtos = new Exceptiondtos();
//                exceptiondtos.setMessage("Something went wrong in Service");
//                exceptiondtos.setResolution("Switch off your PC. Do something productive");
//                responseEntity = new ResponseEntity<>(exceptiondtos,HttpStatus.BAD_REQUEST);
//                return responseEntity;
//            }

        return productService.getProductById(id);

    }

    @GetMapping("")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("")
    public Product createNewProduct(@RequestBody Product product){
        return productService.createNewProduct(product);
    }
    public Product updateProduct(@RequestBody Product product){
        return productService.createNewProduct(product);
    }

}
