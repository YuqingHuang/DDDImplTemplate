package com.hellobank.riskmgmt.limit.repository;

import com.hellobank.riskmgmt.limit.model.CreditLimit;
import com.hellobank.riskmgmt.limit.model.GeneralLimit;
import com.hellobank.riskmgmt.limit.model.ItemizedLimit;

public class LimitRepositoryImpl implements LimitRepository {
    @Override
    public ItemizedLimit itemizedLimitBy(String creditLimitId, String itemizedLimitId) {
        try {
            String sql = "SELECT JSON_CONTENT FROM LIMIT WHERE CREDITLIMITID=:id AND ITEMIZEDLIMITID=:itemID;";
        } catch (Exception e) {}

        // return a mock ItemizedLimit
        return new ItemizedLimit();
    }

    @Override
    public GeneralLimit generalLimitBy(String creditLimitId) {
        try {
            String sql = "SELECT JSON_CONTENT FROM LIMIT WHERE CREDITLIMITID=:id";
        } catch (Exception e) {}

        // return a mock GeneralLimit
        return new CreditLimit().getGeneralLimit();
    }
}
