package com.engineerpro.first.helloworld.services;

import com.engineerpro.first.helloworld.dto.ProductDTO;
import com.engineerpro.first.helloworld.dto.ProductImageDTO;
import com.engineerpro.first.helloworld.model.Product;
import com.engineerpro.first.helloworld.model.ProductImage;
import com.engineerpro.first.helloworld.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface ProductServiceImpl {
    Product createProduct(ProductDTO productDTO) throws Exception;
    Product getProductById(long id) throws Exception;
    public Page<ProductResponse> getAllProducts(PageRequest pageRequest);
    Product updateProduct(long id, ProductDTO productDTO) throws Exception;
    void deleteProduct(long id) throws Exception;
    boolean existsByName(String name);
    ProductImage createProductImage(
            Long productId,
            ProductImageDTO productImageDTO) throws Exception;

}
