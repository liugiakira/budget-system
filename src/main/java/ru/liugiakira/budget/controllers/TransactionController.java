package ru.liugiakira.budget.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.liugiakira.budget.domains.Report;
import ru.liugiakira.budget.domains.Transaction;
import ru.liugiakira.budget.exceptions.ResourseNotFoundException;
import ru.liugiakira.budget.services.TransactionService;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @author k.yakovleva
 */
@RestController
@Component
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) { this.transactionService = transactionService; }

    @GetMapping("/transactions")
    public List<Transaction> retrieveAllTransaction() {
        return transactionService.findAll();
    }

    @GetMapping(path="/transactions", params = {"page", "pageSize"})
    public List<Transaction> retrieveAllTransaction(@RequestParam("page") int page,
                                                    @RequestParam("pageSize") int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<Transaction> resultPage = transactionService.findAll(pageable);
        return resultPage.getContent();
    }

    @GetMapping("/transactions/{id}")
    public Transaction retrieveTransaction(@PathVariable long id) {
        Transaction transaction = transactionService.findById(id);
        if (transaction == null)
            throw new ResourseNotFoundException(String.format("Transaction with id:%d not found", id));
        return transaction;
    }

    @DeleteMapping("/transactions/{id}")
    public void deleteTransaction(@PathVariable long id) {
        transactionService.deleteById(id);
    }

    @PostMapping("/transactions")
    public ResponseEntity<Object> createTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.save(transaction);
        //URL созданного ресурса
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTransaction.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<Object> updateTransaction(@RequestBody Transaction transaction, @PathVariable long id) {
        Transaction transactionExists = transactionService.findById(id);
        if (transactionExists == null)
            return ResponseEntity.notFound().build();
        transaction.setId(id);
        transactionService.save(transaction);
        return ResponseEntity.noContent().build();
    }
}
