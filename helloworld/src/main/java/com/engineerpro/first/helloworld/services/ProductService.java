package com.engineerpro.first.helloworld.services;

import com.engineerpro.first.helloworld.dto.ProductDTO;
import com.engineerpro.first.helloworld.dto.ProductImageDTO;
import com.engineerpro.first.helloworld.exceptions.DataNotFoundException;
import com.engineerpro.first.helloworld.exceptions.InvalidParamException;
import com.engineerpro.first.helloworld.model.Category;
import com.engineerpro.first.helloworld.model.Product;
import com.engineerpro.first.helloworld.model.ProductImage;
import com.engineerpro.first.helloworld.repositories.CategoryRepository;
import com.engineerpro.first.helloworld.repositories.ProductImageRepository;
import com.engineerpro.first.helloworld.repositories.ProductRepository;
import com.engineerpro.first.helloworld.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService implements ProductServiceImpl {
    //    Inject repository
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository productImageRepository;

    /**
     * @param productDTO
     * @return
     * @throws Exception
     */
    @Override
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException {
        Category existCate = categoryRepository
                .findById(productDTO.getCategoryId())
                .orElseThrow(() -> new DataNotFoundException("Can not found category id:" + productDTO.getCategoryId()));
        Product newProduct = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .thumbnail(productDTO.getThumbnail())
                .category(existCate)
                .build();
        return productRepository.save(newProduct);
    }

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Product getProductById(long id) throws Exception {
        return productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Not found product"));
    }

    /**
     * @param pageRequest
     * @return
     */
    @Override
    public Page<ProductResponse> getAllProducts(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest).map(product -> {
            ProductResponse productResponse = ProductResponse.builder()
                    .name(product.getName())
                    .price(product.getPrice())
                    .thumbnail(product.getThumbnail())
                    .description(product.getDescription())
                    .build();
            productResponse.setCreatedAt(product.getCreatedAt());
            productResponse.setUpdatedAt(product.getUpdatedAt());
            return productResponse;
        });
    }


    /**
     * @param id
     * @param productDTO
     * @return
     * @throws Exception
     */
    @Override
    public Product updateProduct(long id, ProductDTO productDTO) throws Exception {
        Product existProduct = getProductById(id);
        Category existCate = categoryRepository
                .findById(productDTO.getCategoryId())
                .orElseThrow(() -> new DataNotFoundException("Can not found category id:" + productDTO.getCategoryId()));
        existProduct.setName(productDTO.getName());
        existProduct.setCategory(existCate);
        existProduct.setPrice(productDTO.getPrice());
        existProduct.setDescription(productDTO.getDescription());
        existProduct.setThumbnail(productDTO.getThumbnail());
        if (existProduct != null) {
            return productRepository.save(existProduct);
        }
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteProduct(long id) {
        Optional<Product> existProduct = productRepository.findById(id);
        existProduct.ifPresent(productRepository::delete);

    }

    /**
     * @param name
     * @return
     */
    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    public ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws DataNotFoundException, InvalidParamException {
        Product existProduct = productRepository
                .findById(productId)
                .orElseThrow(() -> new DataNotFoundException("Can not found category id:" + productImageDTO.getProductId()));
        ProductImage newProductImage = ProductImage.builder()
                .product(existProduct).imageUrl(productImageDTO.getImageUrl()).build();
        //Limit 5 images/product
        int size = productImageRepository.findByProductId(productId).size();
        if (size >= ProductImage.MAX_IMAGE_PER_PRODUCT) {
            throw new InvalidParamException("Not allowed more than 5 pictures!!");
        }
        return productImageRepository.save(newProductImage);
    }
}
