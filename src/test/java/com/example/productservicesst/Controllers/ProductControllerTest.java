package com.example.productservicesst.Controllers;

import com.example.productservicesst.Models.Product;
import com.example.productservicesst.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void testValidGetProductById() {

        Product product = new Product();
        product.setId(1L);
        product.setTitle("Iphone 15");
        product.setPrice(100000.00);

        when(productService.getProductById(1L))
                .thenReturn(product);


        Product outputProduct = productController.getProductById(1L);
        System.out.println("DEBUG");
        assertEquals(product, outputProduct, "OutputProduct is not equal to the product. so that the testcase failing");


    }

    @Test
    void testInvalidGetProductById(){

    }

    @Test
    void getAllProducts() {
    }

    @Test
    void createNewProduct() {
    }

    @Test
    void updateProduct() {
    }
}