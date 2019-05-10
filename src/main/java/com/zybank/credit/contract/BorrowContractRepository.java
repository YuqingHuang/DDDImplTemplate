package com.zybank.credit.contract;

import com.zybank.credit.contract.model.BorrowContract;
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

}
