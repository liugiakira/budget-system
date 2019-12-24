package ru.liugiakira.budget.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.liugiakira.budget.domains.Transaction;
import ru.liugiakira.budget.domains.Values;

import java.util.List;

/**
 * @author k.yakovleva
 */
@Repository
public interface TransactionDao extends JpaRepository<Transaction, Long> {

    @Query("SELECT new ru.liugiakira.budget.domains.Values(" +
                "t.categoryName, sum(case when t.amount <= 0 then 0.0 else t.amount end)) " +
            "FROM Transaction t " +
            "WHERE t.bookingDate >= TO_DATE(:from , 'YYYY-MM-DD') " +
                "and t.bookingDate <= TO_DATE(:to , 'YYYY-MM-DD') " +
                "and (:accountId is null or t.account.id = :accountId)" +
            "GROUP BY t.categoryName")
    List<Values> findIncTransaction(@Param("from") String from, @Param("to") String to, @Param("accountId") Long accountId);

    @Query("SELECT new ru.liugiakira.budget.domains.Values(" +
            "t.categoryName, sum(case when t.amount <= 0 then t.amount else 0.0 end)) " +
            "FROM Transaction t " +
            "WHERE t.bookingDate >= TO_DATE(:from , 'YYYY-MM-DD') " +
            "and t.bookingDate <= TO_DATE(:to , 'YYYY-MM-DD') " +
            "and (:accountId is null or t.account.id = :accountId)" +
            "GROUP BY t.categoryName")
    List<Values> findExpTransaction(@Param("from") String from, @Param("to") String to, @Param("accountId") Long accountId);
}