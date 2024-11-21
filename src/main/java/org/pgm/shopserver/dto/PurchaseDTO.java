package org.pgm.shopserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO { // 화면에 입력받을 때 사용하지만, 출력할때는 엔티티 바로 사용

    private Long id;
    private String username;
    private Long productId;
    private Integer quantity;
    private LocalDateTime purchaseTime;



}
