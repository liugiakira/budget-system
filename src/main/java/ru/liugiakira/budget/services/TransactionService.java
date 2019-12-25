package ru.liugiakira.budget.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.liugiakira.budget.dao.TransactionDao;
import ru.liugiakira.budget.domains.Transaction;

import java.util.List;

/**
 * @author k.yakovleva
 */
@Service
@Component
public class TransactionService {
    private final TransactionDao transactionDao;

    public TransactionService(TransactionDao transactionDao) { this.transactionDao = transactionDao; }

    public List<Transaction> findAll() {
        return transactionDao.findAll();
    }

    public Page<Transaction> findAll(Pageable pageable) {
        return transactionDao.findAll(pageable);
    }

    public Transaction findById(Long id) {
        return transactionDao.findOne(id);
    }

    public Transaction save(Transaction transaction) {
        return transactionDao.save(transaction);
    }

    public void deleteById(Long id) {
        transactionDao.delete(id);
    }
}
