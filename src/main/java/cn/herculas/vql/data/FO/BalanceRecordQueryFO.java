package cn.herculas.vql.data.FO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BalanceRecordQueryFO {
    private final String startDate;
    private final String endDate;

    private final String address;

    private final Double expenseBottom;
    private final Double expensePeak;

    private final Double incomeBottom;
    private final Double incomePeak;
}
