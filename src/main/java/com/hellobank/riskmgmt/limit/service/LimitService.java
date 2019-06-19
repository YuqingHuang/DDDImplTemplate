package com.hellobank.riskmgmt.limit;

import annotations.RULE;
import com.hellobank.riskmgmt.limit.model.GeneralLimit;
import com.hellobank.riskmgmt.limit.model.ItemizedLimit;
import common.ExecuteResult;

public class LimitService {
    private final LimitRepository repository;

    public LimitService(LimitRepository repository) {
        this.repository = repository;
    }

    public ExecuteResult preOccupied(String creditLimitId, String itemizedLimitId, int amount) {
        ItemizedLimit itemizedLimit = repository.itemizedLimitBy(creditLimitId, itemizedLimitId);

        if (itemizedLimit.availableAmount() > amount) {
            itemizedLimit.addPreOccupiedAmount(amount);
            effectGeneralLimit(creditLimitId, amount);
            generatePreOccupiedRecord();

            return ExecuteResult.success;
        }

        return ExecuteResult.fail;
    }

    public ExecuteResult occupied(String creditLimitId, String itemizedLimitId, int amount) {

        return ExecuteResult.success;
    }

    @RULE
    private void effectGeneralLimit(String creditLimitId, int amount) {
        //RULE: preoccupy itemizedLimit would effect related generalLimit
        GeneralLimit generalLimit = repository.generalLimitBy(creditLimitId);
        generalLimit.addPreOccupiedAmount(amount);
    }

    private void generatePreOccupiedRecord() {
    }
}
