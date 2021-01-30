package cn.herculas.vql.controller;

import cn.herculas.vql.data.FO.BalanceRecordQueryFO;
import cn.herculas.vql.data.VO.ResponseVO;
import cn.herculas.vql.service.BalanceService;
import cn.herculas.vql.util.wrapper.ResponseWrapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/sum")
    public ResponseVO<?> getBalanceSum(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String address) {
        BalanceRecordQueryFO queryFO = new BalanceRecordQueryFO(startDate, endDate, address,
                null, null, null, null);
        return ResponseWrapper.success(balanceService.retrieveBalanceSum(queryFO));
    }

    @GetMapping("/records")
    public ResponseVO<?> getBalanceRecords(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Double expenseBottom,
            @RequestParam(required = false) Double expensePeak,
            @RequestParam(required = false) Double incomeBottom,
            @RequestParam(required = false) Double incomePeak
    ) {
        BalanceRecordQueryFO queryFO = new BalanceRecordQueryFO(startDate, endDate, address,
                expenseBottom, expensePeak, incomeBottom, incomePeak);
        return ResponseWrapper.success(balanceService.retrieveBalanceRecords(queryFO));
    }

}
