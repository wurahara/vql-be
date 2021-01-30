package cn.herculas.vql.service;

import cn.herculas.vql.data.DO.Transaction;
import cn.herculas.vql.data.FO.TransactionQueryFO;

import java.util.List;

public interface TransactionService {
    List<Transaction> retrieveTransactions(TransactionQueryFO transactionQueryFO);
}
