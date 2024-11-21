package org.pgm.shopserver.service;

import org.pgm.shopserver.dto.ProductDTO;
import org.pgm.shopserver.model.Product;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);
    void deleteProduct(Long id);
    List<ProductDTO> findAllProducts();

    default Product dtoToEntity(ProductDTO productDTO) {
        Product product = Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .build();
        return product;
    }
    default ProductDTO entityToDTO(Product product) {
        ProductDTO productDTO = ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .createTime(product.getCreateTime())
                .build();
        return productDTO;
    }
}
