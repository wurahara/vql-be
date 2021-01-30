package cn.herculas.vql.repository.implement;

import cn.herculas.vql.data.DO.Transaction;
import cn.herculas.vql.data.FO.TransactionQueryFO;
import cn.herculas.vql.repository.TransactionRepository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private final MongoTemplate template;

    public TransactionRepositoryImpl(MongoTemplate template) {
        this.template = template;
    }

    @Override
    public List<Transaction> findAllTransactions(TransactionQueryFO queryFO) {

        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();

        if (queryFO.getStartTimestamp() != null)
            criteriaList.add(Criteria.where("timestamp").gte(queryFO.getStartTimestamp()));
        if (queryFO.getEndTimestamp() != null)
            criteriaList.add(Criteria.where("timestamp").lte(queryFO.getEndTimestamp()));

        if (queryFO.getFromAddr() != null && !queryFO.getFromAddr().isEmpty() && !queryFO.getFromAddr().isBlank())
            criteriaList.add(Criteria.where("from").is(queryFO.getFromAddr()));
        if (queryFO.getToAddr() != null && !queryFO.getToAddr().isEmpty() && !queryFO.getToAddr().isBlank())
            criteriaList.add(Criteria.where("to").is(queryFO.getToAddr()));

        if (queryFO.getValueBottom() != null)
            criteriaList.add(Criteria.where("value").gte(queryFO.getValueBottom()));
        if (queryFO.getValuePeak() != null)
            criteriaList.add(Criteria.where("value").lte(queryFO.getValuePeak()));

        if (criteriaList.isEmpty()) return null;

        query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        return template.find(query, Transaction.class);
    }
}
