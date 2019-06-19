package com.hellobank.credit.contract.model;

import annotations.Entity;
import com.hellobank.riskmgmt.limit.model.ProductId;

@Entity
public class BorrowContractItem {
    private ProductId product;

    public BorrowContractItem(String productId) {
        this.product = new ProductId(productId);
    }
}
