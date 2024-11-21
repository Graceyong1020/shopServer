package org.pgm.shopserver.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pgm.shopserver.dto.PurchaseDTO;
import org.pgm.shopserver.model.Product;
import org.pgm.shopserver.model.Purchase;
import org.pgm.shopserver.model.User;
import org.pgm.shopserver.repository.ProductRepostiory;
import org.pgm.shopserver.repository.UserRepository;
import org.pgm.shopserver.repository.projection.PurchaseItem;
import org.pgm.shopserver.repository.projection.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{

    private final UserRepository userRepository;
    private final ProductRepostiory productRepostiory;
    private final PurchaseRepository purchaseRepository;

    @Override
    public Purchase savePurchase(PurchaseDTO purchaseDTO) {
        Purchase purchase = Purchase.builder()
                .quantity(purchaseDTO.getQuantity())
                .build();


        User user = userRepository.findByUsername(purchaseDTO.getUsername());
        Product product = productRepostiory.findById(purchaseDTO.getProductId()).orElseThrow();
        purchase.setUser(user);
        purchase.setProduct(product);
        purchase.setPurchaseTime(LocalDateTime.now());

        Purchase savedPurchase = purchaseRepository.save(purchase);
        return savedPurchase;
    }

    @Override
    public List<PurchaseItem> findPurchaseItemsOfUser(String username) {
        User user = userRepository.findByUsername(username);

        return purchaseRepository.findAllPurchasesOfUser(username);
    }

    @Override
    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);

    }
}
