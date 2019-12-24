package ru.liugiakira.budget.domains;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Отчет о расходах и доходах по категориям за заданный период
 * с опциональным фильтром по аккаунтам
 * @author k.yakovleva
 */
public class Report {

    /**
     * Доходы по категориям
     */
    @JsonProperty("inc")
    private Map<String, Double> incTransaction = new LinkedHashMap<>();
    /**
     * Расходы по категориям
     */
    @JsonProperty("exp")
    private Map<String, Double> expTransaction = new LinkedHashMap<>();

    public Map<String, Double> getIncTransaction() {
        return incTransaction;
    }

    public void setIncTransaction(Map<String, Double> incTransaction) {
        this.incTransaction = incTransaction;
    }

    public Map<String, Double> getExpTransaction() {
        return expTransaction;
    }

    public void setExpTransaction(Map<String, Double> expTransaction) {
        this.expTransaction = expTransaction;
    }
}
