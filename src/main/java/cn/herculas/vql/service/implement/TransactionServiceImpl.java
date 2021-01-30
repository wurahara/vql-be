package cn.herculas.vql.service.implement;

import cn.herculas.vql.data.DO.Transaction;
import cn.herculas.vql.data.FO.TransactionQueryFO;
import cn.herculas.vql.repository.TransactionRepository;
import cn.herculas.vql.service.TransactionService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> retrieveTransactions(TransactionQueryFO transactionQueryFO) {
        return transactionRepository.findAllTransactions(transactionQueryFO);
    }
}
