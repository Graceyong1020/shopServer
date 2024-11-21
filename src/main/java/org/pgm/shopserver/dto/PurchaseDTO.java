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
public class PurchaseDTO {

    private Long id;
    private Long username;
    private Long productId;
    private Integer quantity;
    private LocalDateTime purchaseTime;



}
