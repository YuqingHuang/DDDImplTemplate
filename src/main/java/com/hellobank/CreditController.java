package com.hellobank;


import com.hellobank.common.ExecuteResult;

import java.time.LocalDateTime;
import java.util.List;

//@RequestMapping(value = "/borrow-contracts")
public class CreditController {
    private CreditApplicationService service;

//    @PostMapping
//    @ResponseStatus(CREATED)
//    @RequestBody
    public ResponseBody createBorrowContract(CreateBorrowContractRequestBody requestBody) {
        ExecuteResult result = service.createBorrowContract(requestBody.getContractBasicInfo(), requestBody.getLimitOccupiedSolution());
        return ResponseBody.body(result.toString());

    }
}


class ResponseBody {
    private String description;

    public ResponseBody(String description) {
        this.description = description;
    }

    public static ResponseBody body(String description) {
        return new ResponseBody(description);
    }
}



class CreateBorrowContractRequestBody {
    private LimitOccupiedSolution limitOccupiedSolution;
    private BorrowContractBasicInfo contractBasicInfo;

//  @JsonCreator
    public CreateBorrowContractRequestBody(LimitOccupiedSolution limitOccupiedSolution, BorrowContractBasicInfo contractBasicInfo) {
        this.limitOccupiedSolution = limitOccupiedSolution;
        this.contractBasicInfo = contractBasicInfo;
    }

    public LimitOccupiedSolution getLimitOccupiedSolution() {
        return limitOccupiedSolution;
    }

    public BorrowContractBasicInfo getContractBasicInfo() {
        return contractBasicInfo;
    }
}

class LimitOccupiedSolution {
    String creditLimitId;
    String itemizedLimitId;
    List<String> productIdList;

//  @JsonCreator
//  @JsonProperty("limit-info")

    public LimitOccupiedSolution(String creditLimitId, String itemizedLimitId, List<String> productIdList) {
        this.creditLimitId = creditLimitId;
        this.itemizedLimitId = itemizedLimitId;
        this.productIdList = productIdList;
    }
}

class BorrowContractBasicInfo {
    int amount;
    int rate;
    LocalDateTime expiredTime;

//  @JsonCreator
//  @JsonProperty("contract-basic-info")
    public BorrowContractBasicInfo(int amount, int rate, LocalDateTime expiredTime) {
        this.amount = amount;
        this.rate = rate;
        this.expiredTime = expiredTime;
    }
}