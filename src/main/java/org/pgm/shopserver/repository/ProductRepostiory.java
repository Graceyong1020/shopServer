package org.pgm.shopserver.repository;

import org.pgm.shopserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepostiory extends JpaRepository<Product, Long> {
}
