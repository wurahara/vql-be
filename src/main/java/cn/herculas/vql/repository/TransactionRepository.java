package cn.herculas.vql.repository;

import cn.herculas.vql.data.DO.Transaction;
import cn.herculas.vql.data.FO.TransactionQueryFO;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> findAllTransactions(TransactionQueryFO transactionQueryFO);
}
