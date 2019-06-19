package com.hellobank.credit.contract;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import com.hellobank.credit.contract.model.BorrowContract;
import com.hellobank.credit.contract.model.BorrowContractItem;
import common.ExecuteResult;

import java.time.LocalDateTime;

//ONLY persistence
public class BorrowContractRepository {
    public ExecuteResult save(BorrowContract contract) {
        String sql = "INSERT INTO CONTRACTS (ID, JSON_CONTENT) VALUES (:id, :json) " +
                "ON DUPLICATE KEY UPDATE JSON_CONTENT=:json;";
        return ExecuteResult.success;
    }

    public BorrowContract byId(int id) {
        try {
            String sql = "SELECT JSON_CONTENT FROM CONTRACTS WHERE ID=:id;";
        } catch (Exception e) {}

        // return a mock contract
        return new BorrowContract(100, 0.1f, LocalDateTime.now(), null);
    }

    public Iterators.Array<BorrowContractItem> byId(int contractId) {
        try {
            String sql = "SELECT JSON_CONTENT FROM CONTRACTS_ITEMS WHERE ID=:id;";
        } catch (Exception e) {}

        // return a mock contract
        return new Iterators.Array<BorrowContractItem>("product123");
    }

}
