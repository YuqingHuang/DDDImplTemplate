package com.hellobank.credit.contract.service;

import annotations.ApplicationService;
import annotations.RULE;
import com.hellobank.credit.contract.model.BorrowContract;
import com.hellobank.credit.contract.model.BorrowContractItem;
import com.hellobank.credit.contract.repository.BorrowContractRepository;
import com.hellobank.common.ExecuteResult;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationService
public class BorrowContractService {
    private final BorrowContractRepository repository;

    public BorrowContractService(BorrowContractRepository repository) {
        this.repository = repository;
    }

    public ExecuteResult create(int amount, int rate, LocalDateTime expiredTime, List<String> productIdList) {
        List<BorrowContractItem> borrowContractItems = createOneContractItemPerProduct(productIdList);

        BorrowContract borrowContract = new BorrowContract(amount, rate, expiredTime, borrowContractItems);
        return repository.save(borrowContract);
    }

    @RULE
    private List<BorrowContractItem> createOneContractItemPerProduct(List<String> productIdList) {
        //RULE: given multiple products, when create borrow contract, then create one contract item per product.
        return productIdList.stream().map(BorrowContractItem::new).collect(Collectors.toList());
    }

    public BorrowContract byId(Integer contractId) {
        return repository.byId(contractId);
    }
}
