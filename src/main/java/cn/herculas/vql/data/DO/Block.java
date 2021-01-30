package cn.herculas.vql.data.DO;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "ethereumBlock")
public class Block {
    @Id
    private String id;

    private Long number;
    private Long difficulty;
    private Long gasLimit;
    private Long gasUsed;
    private Long timestamp;

    private String hash;
    private String parentHash;
    private String nonce;
    private String txTrieRoot;
    private String stateRoot;
    private String receiptTrieRoot;
    private String miner;
    private String extraData;

    private List<String> uncles;
    private List<String> transactions;
}
