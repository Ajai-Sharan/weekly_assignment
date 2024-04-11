package com.example.productservicesst.Service;

import com.example.productservicesst.Exceptions.PageNotFound;
import com.example.productservicesst.Models.Category;
import com.example.productservicesst.Models.Product;
import com.example.productservicesst.dtos.FakeStoreProductDto;
//import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{



    @Override
    public Product getProductById(Long id) {


        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

        if(fakeStoreProductDto == null){
            throw new PageNotFound(id, "Please enter valid product id");
        }

        return ConvertFakeStoreToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < fakeStoreProductDtos.length; i++) {
            if(fakeStoreProductDtos[i] == null){
                products.add(null);
            }
            assert fakeStoreProductDtos[i] != null;
            products.add(ConvertFakeStoreToProduct(fakeStoreProductDtos[i]));
        }


        return products;




    }

    @Override
    public Product createNewProduct(Product product) {
        return null;
    }


    private Product ConvertFakeStoreToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setId(fakeStoreProductDto.getId());
        category.setName(fakeStoreProductDto.getCategory());

        product.setCategory(category);

        return product;
    }
}
