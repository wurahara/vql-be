package cn.herculas.vql.controller;

import cn.herculas.vql.data.FO.TransactionQueryFO;
import cn.herculas.vql.data.VO.ResponseVO;
import cn.herculas.vql.service.TransactionService;
import cn.herculas.vql.util.parser.TransactionQueryParser;
import cn.herculas.vql.util.wrapper.ResponseWrapper;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseVO<?> queryTransaction(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String fromAddr,
            @RequestParam(required = false) String toAddr,
            @RequestParam(required = false) Double valueBottom,
            @RequestParam(required = false) Double valuePeak) {

        TransactionQueryFO queryFO = TransactionQueryParser.formParser(startDate, endDate,
                fromAddr, toAddr, valueBottom, valuePeak);

        return ResponseWrapper.success(transactionService.retrieveTransactions(queryFO));
    }
}
