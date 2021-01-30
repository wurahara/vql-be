package cn.herculas.vql.util.parser;

import cn.herculas.vql.data.FO.TransactionQueryFO;

import java.sql.Timestamp;

public class TransactionQueryParser {

    public static TransactionQueryFO formParser(String startDate, String endDate,
                                                String fromAddr, String toAddr,
                                                Double valBtm, Double valPk) {

        Long startTimestamp, endTimestamp;

        if (startDate != null) {
            startTimestamp = Timestamp.valueOf(startDate + " 00:00:00").getTime() / 1000;
        } else {
            startTimestamp = null;
        }
        if (endDate != null) {
            endTimestamp = Timestamp.valueOf(endDate + " 00:00:00").getTime() / 1000;
        } else {
            endTimestamp = null;
        }

        return new TransactionQueryFO(startTimestamp, endTimestamp, fromAddr, toAddr, valBtm, valPk);
    }
}
