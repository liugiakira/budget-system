package ru.liugiakira.budget.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liugiakira.budget.domains.Account;

/**
 * @author k.yakovleva
 */
@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
}
