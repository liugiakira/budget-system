package ru.liugiakira.budget.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.liugiakira.budget.dao.AccountDao;
import ru.liugiakira.budget.domains.Account;

import java.util.List;

/**
 * @author k.yakovleva
 */
@Service
@Component
public class AccountService {

    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) { this.accountDao = accountDao; }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Long id) {
        return accountDao.findOne(id);
    }

    public Account save(Account account) {
        return accountDao.save(account);
    }

    public void deleteById(Long id) {
        accountDao.delete(id);
    }
}
