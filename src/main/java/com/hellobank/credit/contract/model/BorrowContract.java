package com.hellobank.credit.contract.model;

import annotations.AggregateRoot;
import annotations.Entity;

import java.time.LocalDateTime;
import java.util.List;

@AggregateRoot
@Entity
public class BorrowContract {
    private int amount;
    private float rate;
    private LocalDateTime expiredDate;
    private List<BorrowContractItem> items;

    private List<BorrowContractImagesInfo> images;
    private BorrowContractUnderwritingInfo underwritingInfo;

    public BorrowContract(int amount, float rate, LocalDateTime expiredDate, List<BorrowContractItem> borrowContractItems) {
        this.amount = amount;
        this.rate = rate;
        this.expiredDate = expiredDate;

        this.items = borrowContractItems;
    }


    public List<BorrowContractItem> getItems() {
        return items;
    }
}
