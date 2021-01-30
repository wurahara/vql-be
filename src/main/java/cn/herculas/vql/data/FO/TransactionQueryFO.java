package cn.herculas.vql.data.FO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransactionQueryFO {

    private final Long startTimestamp;
    private final Long endTimestamp;

    private final String fromAddr;
    private final String toAddr;

    private final Double valueBottom;
    private final Double valuePeak;
}
