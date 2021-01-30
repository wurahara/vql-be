package cn.herculas.vql.util.parser;

import cn.herculas.vql.data.FO.BalanceRecordQueryFO;

public class BalanceQueryParser {

    public static BalanceRecordQueryFO formParser(String startDate, String endDate,
                                                        String address,
                                                        Double expenseBottom, Double expensePeak,
                                                        Double incomeBottom, Double incomePeak) {
        return new BalanceRecordQueryFO(startDate, endDate, address,
                expenseBottom, expensePeak, incomeBottom, incomePeak);
    }
}
