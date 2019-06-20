package com.hellobank.credit.contract.repository;

import com.hellobank.credit.contract.model.BorrowContract;
import com.hellobank.credit.contract.model.BorrowContractItem;
import common.ExecuteResult;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//ONLY persistence
public class BorrowContractRepositoryImpl implements BorrowContractRepository {
    @Override
    public ExecuteResult save(BorrowContract contract) {
        String sql = "INSERT INTO CONTRACTS (ID, JSON_CONTENT) VALUES (:id, :json) " +
                "ON DUPLICATE KEY UPDATE JSON_CONTENT=:json;";
        return ExecuteResult.success;
    }

    @Override
    public BorrowContract byId(int id) {
        try {
            String sql = "SELECT JSON_CONTENT FROM CONTRACTS WHERE ID=:id;";
        } catch (Exception e) {}

        // return a mock contract
        return new BorrowContract(100, 0.1f, LocalDateTime.now(), null);
    }

    @Override
    public List<BorrowContractItem> borrowContractItemsById(int contractId) {
        try {
            String sql = "SELECT JSON_CONTENT FROM CONTRACTS_ITEMS WHERE ID=:id;";
        } catch (Exception e) {}

        List<BorrowContractItem> result = new ArrayList<>();
        result.add(new BorrowContractItem("product123"));
        // return a mock contract
        return result;
    }

}
