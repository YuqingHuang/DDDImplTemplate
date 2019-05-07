package com.zybank.credit.contract;

import com.zybank.credit.contract.model.BorrowContract;

//ONLY persistence
public class BorrowContractRepository {
    public void save(BorrowContract contract) {
        String sql = "INSERT INTO CONTRACTS (ID, JSON_CONTENT) VALUES (:id, :json) " +
                "ON DUPLICATE KEY UPDATE JSON_CONTENT=:json;";
    }

    public BorrowContract byId(int id) {
        try {
            String sql = "SELECT JSON_CONTENT FROM ORDERS WHERE ID=:id;";
        } catch (Exception e) {}

        return new BorrowContract(null, null, null);
    }

}
