package cn.herculas.vql.data.DO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ethereumBalance")
public class Balance {
    @Id
    private String id;

    private Double balance;
    private Double change;
    private Double expense;
    private Double income;

    private String addr;
    private String date;
}
