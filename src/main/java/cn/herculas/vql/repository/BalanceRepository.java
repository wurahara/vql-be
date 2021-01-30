package cn.herculas.vql.repository;

import cn.herculas.vql.data.DO.Balance;
import cn.herculas.vql.data.FO.BalanceRecordQueryFO;

import java.util.List;

public interface BalanceRepository {
    List<Balance> findAllBalanceRecords(BalanceRecordQueryFO balanceRecordQueryFO);
}
