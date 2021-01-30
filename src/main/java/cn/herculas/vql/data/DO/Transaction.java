package cn.herculas.vql.data.DO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ethereumTransaction")
public class Transaction {
    @Id
    private String id;

    private String blockHash;
    private String data;
    private String from;
    private String to;
    private String hash;

    private Long nonce;
    private Long timestamp;
    private Long blockNumber;
    private Long gas;
    private Long transactionIndex;

    private Double gasPrice;
    private Double value;
}
