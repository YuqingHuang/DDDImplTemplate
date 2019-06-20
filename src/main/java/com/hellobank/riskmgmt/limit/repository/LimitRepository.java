package com.hellobank.riskmgmt.limit.repository;

import com.hellobank.riskmgmt.limit.model.GeneralLimit;
import com.hellobank.riskmgmt.limit.model.ItemizedLimit;

public interface LimitRepository {
    ItemizedLimit itemizedLimitBy(String creditLimitId, String itemizedLimitId);

    GeneralLimit generalLimitBy(String creditLimitId);
}
