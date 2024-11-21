package org.pgm.shopserver.service;

import org.pgm.shopserver.dto.PurchaseDTO;
import org.pgm.shopserver.model.Purchase;
import org.pgm.shopserver.repository.projection.PurchaseItem;

import java.util.List;

public interface PurchaseService {

    Purchase savePurchase(PurchaseDTO purchaseDTO); // 엔티티에 user,product만 있음. 그래서 입력받을 때는 DTO, 출력할 때는 엔티티 사용
    // product 정보 전체가 필요한데, purchase 안에 있는 모든 정보를 가져오기 위해서는 DTO로 변환해서 가져와야함
    List<PurchaseItem> findPurchaseItemsOfUser(String username);
    List<Purchase> findAllPurchases();
    void deletePurchase(Long id);

}
