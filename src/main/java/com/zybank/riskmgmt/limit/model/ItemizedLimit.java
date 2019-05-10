package com.zybank.riskmgmt.limit.model;

import annotations.Entity;

import java.util.List;

@Entity
public class ItemizedLimit {
    private List<ProductId> productIdList;
    private WarrantSolution warrantSolution;

    private Usage usage;

    private Integer amount;
    private Integer validityPeriod;

    private List<Integer> preOccupiedAmounts;

    public void addPreOccupiedAmount(Integer preOccupiedAmount) {
        preOccupiedAmounts.add(preOccupiedAmount);
    }

    public Integer availableAmount() {
        return amount - preOccupiedAmounts.stream().mapToInt(Integer::intValue).sum();
    }
}


class WarrantSolution {
}