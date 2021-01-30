package cn.herculas.vql.service;

import cn.herculas.vql.data.DO.Balance;
import cn.herculas.vql.data.FO.BalanceRecordQueryFO;

import java.util.List;
import java.util.Map;

public interface BalanceService {
    Map<String, Double> retrieveBalanceSum(BalanceRecordQueryFO balanceRecordQueryFO);
    List<Balance> retrieveBalanceRecords(BalanceRecordQueryFO balanceRecordQueryFO);
}
