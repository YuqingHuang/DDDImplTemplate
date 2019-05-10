package com.zybank.riskmgmt.limit;

import com.zybank.riskmgmt.limit.model.CreditLimit;
import com.zybank.riskmgmt.limit.model.GeneralLimit;
import com.zybank.riskmgmt.limit.model.ItemizedLimit;

public class LimitRepository {
    public ItemizedLimit itemizedLimitBy(String creditLimitId, String itemizedLimitId) {
        try {
            String sql = "SELECT JSON_CONTENT FROM LIMIT WHERE CREDITLIMITID=:id AND ITEMIZEDLIMITID=:itemID;";
        } catch (Exception e) {}

        // return a mock ItemizedLimit
        return new ItemizedLimit();
    }

    public GeneralLimit generalLimitBy(String creditLimitId) {
        try {
            String sql = "SELECT JSON_CONTENT FROM LIMIT WHERE CREDITLIMITID=:id";
        } catch (Exception e) {}

        // return a mock GeneralLimit
        return new CreditLimit().getGeneralLimit();
    }
}
