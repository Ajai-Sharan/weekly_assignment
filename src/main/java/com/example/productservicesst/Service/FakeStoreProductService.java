package com.example.productservicesst.Service;

import com.example.productservicesst.Models.Category;
import com.example.productservicesst.Models.Product;
import com.example.productservicesst.dtos.FakeStoreProductDto;
//import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{



    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

        if(fakeStoreProductDto == null){
            return null;
        }







        return ConvertFakeStoreToProduct(fakeStoreProductDto);
    }

//    @Override
//    public List<Product> getAllProducts() {
//        return null;
//    }

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
