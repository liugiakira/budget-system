package ru.liugiakira.budget.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.liugiakira.budget.dao.TransactionDao;
import ru.liugiakira.budget.domains.Report;
import ru.liugiakira.budget.domains.Values;

import javax.transaction.Transactional;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * @author k.yakovleva
 */
@Service
@Component
public class ReportService {

    private final TransactionDao transactionDao;

    public ReportService(TransactionDao transactionDao) { this.transactionDao = transactionDao; }

    /**
     * Отчета о расходах и доходах по категориям за заданный период
     *  с опциональным фильтром по аккаунтам
     * @param from Дата с (обязательно)
     * @param to Дата по (обязательно)
     * @param accountId ид счета (не обязательно)
     * @return отчет
     */
    @Transactional
    public Report findTransaction(String from, String to, Long accountId) {
        Report report = new Report();
        report.setIncTransaction(transactionDao.findIncTransaction(from, to, accountId)
                .stream()
                .collect(Collectors
                        .toMap(Values::getKey, v -> (Double)v.getValue(),(oldValue, newValue) -> oldValue, LinkedHashMap::new)));
        report.setExpTransaction(transactionDao.findExpTransaction(from, to, accountId)
                .stream()
                .collect(Collectors
                        .toMap(Values::getKey, v -> (Double)v.getValue(), (oldValue, newValue) -> oldValue, LinkedHashMap::new)));
        return report;
    }
}
