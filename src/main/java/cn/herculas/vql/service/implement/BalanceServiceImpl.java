package cn.herculas.vql.service.implement;

import cn.herculas.vql.data.DO.Balance;
import cn.herculas.vql.data.FO.BalanceRecordQueryFO;
import cn.herculas.vql.repository.BalanceRepository;
import cn.herculas.vql.service.BalanceService;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository repository;

    public BalanceServiceImpl(BalanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, Double> retrieveBalanceSum(BalanceRecordQueryFO balanceRecordQueryFO) {

        List<Balance> balanceRecords = this.retrieveBalanceRecords(balanceRecordQueryFO);

        Map<String, Double> sum = new LinkedHashMap<>();

        sum.put("income", balanceRecords.parallelStream().mapToDouble(Balance::getIncome).sum());
        sum.put("expense", balanceRecords.parallelStream().mapToDouble(Balance::getExpense).sum());
        sum.put("change", balanceRecords.parallelStream().mapToDouble(Balance::getChange).sum());

        return sum;
    }

    @Override
    public List<Balance> retrieveBalanceRecords(BalanceRecordQueryFO balanceRecordQueryFO) {
        return repository.findAllBalanceRecords(balanceRecordQueryFO);
    }
}
