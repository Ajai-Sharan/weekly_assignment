package com.example.productservicesst.Service;

import com.example.productservicesst.Exceptions.PageNotFound;
import com.example.productservicesst.Models.Category;
import com.example.productservicesst.Models.Product;
import com.example.productservicesst.Repository.CategoryRepository;
import com.example.productservicesst.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;


@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new PageNotFound(id,"The id does not contain any content");
        }

        Product product = optionalProduct.get();

        return product;

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createNewProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() == null){
            product.setCategory(categoryRepository.save(category));
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        product1.setCategory(optionalCategory.get());
        return product1;

    }
}
