package com.ofsystem.Config.Braintree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseFilter {
    private String nonce;
    private BigDecimal amount;
}
