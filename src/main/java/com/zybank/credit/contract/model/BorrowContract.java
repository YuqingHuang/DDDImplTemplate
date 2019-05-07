package com.zybank.credit.contract.model;

import annotations.AggregateRoot;
import annotations.Entity;

import java.util.ArrayList;
import java.util.List;

@AggregateRoot
@Entity
public class BorrowContract {
    private List<BorrowContractImagesInfo> images;
    private ArrayList<BorrowContractItem> items;
    private BorrowContractUnderwritingInfo underwritingInfo;

    public BorrowContract(List<BorrowContractImagesInfo> images, ArrayList<BorrowContractItem> items, BorrowContractUnderwritingInfo underwritingInfo) {
        this.images = images;
        this.items = items;
        this.underwritingInfo = underwritingInfo;
    }
}
