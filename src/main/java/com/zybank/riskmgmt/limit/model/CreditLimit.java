package com.zybank.riskmgmt.limit.model;

import annotations.AggregateRoot;

import java.util.ArrayList;

@AggregateRoot
public class CreditLimit {
    private ArrayList<ItemizedLimit> itemizedLimits;
    private GeneralLimit generalLimit;


    public GeneralLimit getGeneralLimit() {
        return generalLimit;
    }
}
