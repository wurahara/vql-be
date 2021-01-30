package cn.herculas.vql.repository.implement;

import cn.herculas.vql.data.DO.Balance;
import cn.herculas.vql.data.FO.BalanceRecordQueryFO;
import cn.herculas.vql.repository.BalanceRepository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BalanceRepositoryImpl implements BalanceRepository {

    private final MongoTemplate template;

    public BalanceRepositoryImpl(MongoTemplate template) {
        this.template = template;
    }

    @Override
    public List<Balance> findAllBalanceRecords(BalanceRecordQueryFO queryFO) {

        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();

        if (queryFO.getStartDate() != null && !queryFO.getStartDate().isEmpty() && !queryFO.getStartDate().isBlank())
            criteriaList.add(Criteria.where("date").gte(queryFO.getStartDate()));
        if (queryFO.getEndDate() != null && !queryFO.getEndDate().isEmpty() && !queryFO.getEndDate().isBlank())
            criteriaList.add(Criteria.where("date").lte(queryFO.getEndDate()));

        if (queryFO.getAddress() != null && !queryFO.getAddress().isEmpty() && !queryFO.getAddress().isBlank())
            criteriaList.add(Criteria.where("addr").is(queryFO.getAddress()));

        if (queryFO.getExpenseBottom() != null)
            criteriaList.add(Criteria.where("expense").gte(queryFO.getExpenseBottom()));
        if (queryFO.getExpensePeak() != null)
            criteriaList.add(Criteria.where("expense").lte(queryFO.getExpensePeak()));

        if (queryFO.getIncomeBottom() != null)
            criteriaList.add(Criteria.where("income").gte(queryFO.getIncomeBottom()));
        if (queryFO.getIncomePeak() != null)
            criteriaList.add(Criteria.where("income").lte(queryFO.getIncomePeak()));

        if (criteriaList.isEmpty()) return null;

        query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        return template.find(query, Balance.class);
    }
}
