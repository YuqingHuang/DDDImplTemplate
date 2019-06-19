package com.hellobank;

import com.hellobank.credit.contract.BorrowContractService;
import com.hellobank.riskmgmt.limit.LimitService;
import common.ExecuteResult;

public class CreditApplicationService {
    private BorrowContractService borrowContractService;
    private LimitService limitService;

    public CreditApplicationService(BorrowContractService borrowContractService, LimitService limitService) {
        this.borrowContractService = borrowContractService;
        this.limitService = limitService;
    }

    public ExecuteResult createBorrowContract(BorrowContractBasicInfo contractBasicInfo, LimitOccupiedSolution limitOccupiedSolution) {
        //Virtual RULE: only select one itemized limit for one borrow contract
        ExecuteResult result = limitService.preOccupied(limitOccupiedSolution.creditLimitId, limitOccupiedSolution.itemizedLimitId, contractBasicInfo.amount);
        if (result != ExecuteResult.success) {
            return result;
        }

        return borrowContractService.create(contractBasicInfo.amount, contractBasicInfo.rate, contractBasicInfo.expiredTime, limitOccupiedSolution.productIdList);
    }
}

