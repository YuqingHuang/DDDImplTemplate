package com.zybank.credit.contract;

import annotations.ApplicationService;
import com.zybank.credit.contract.model.BorrowContract;

@ApplicationService
public class BorrowContractService {
    private final BorrowContractRepository repository;

    public BorrowContractService(BorrowContractRepository repository) {
        this.repository = repository;
    }

    public int create() {
        repository.save(new BorrowContract(null, null, null));
        return 1;
    }
}
