package com.hellobank.riskmgmt.limit.model;

import annotations.Entity;

@Entity
public class GeneralLimit {
    private float exposureLimitAmount;
    private float lowRiskLimitAmount;

    public void addPreOccupiedAmount(int amount) {
        //preoccupy exposure limit amount
    }
}
