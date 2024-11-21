package org.pgm.shopserver.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pgm.shopserver.dto.ProductDTO;
import org.pgm.shopserver.model.Product;
import org.pgm.shopserver.repository.ProductRepostiory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepostiory productRepostiory;

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = dtoToEntity(productDTO);
        product.setCreateTime(LocalDateTime.now());
        return entityToDTO(productRepostiory.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepostiory.deleteById(id);

    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<Product> products = productRepostiory.findAll();
        List<ProductDTO> productDTOs = products.stream()
                .map(product -> entityToDTO(product))
                .collect(Collectors.toList());
        return productDTOs;
    } // list에 있는 product들을 하나씩 꺼내서 entityToDTO를 적용하여 productDTO로 변환한 후 list에 담아 반환
}
