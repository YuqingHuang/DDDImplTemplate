package com.hellobank.credit.contract.repository;

import com.hellobank.credit.contract.model.BorrowContract;
import com.hellobank.credit.contract.model.BorrowContractItem;
import com.hellobank.common.ExecuteResult;

import java.util.List;

public interface BorrowContractRepository {
    ExecuteResult save(BorrowContract contract);

    BorrowContract byId(int id);

    List<BorrowContractItem> borrowContractItemsById(int contractId);
}
