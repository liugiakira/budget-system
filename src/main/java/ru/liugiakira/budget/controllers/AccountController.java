package ru.liugiakira.budget.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.liugiakira.budget.domains.Account;
import ru.liugiakira.budget.exceptions.ResourseNotFoundException;
import ru.liugiakira.budget.services.AccountService;

import java.net.URI;
import java.util.List;

/**
 * @author k.yakovleva
 */
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) { this.accountService = accountService; }

    @GetMapping("/accounts")
    public List<Account> retrieveAllAccounts() {
        return accountService.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account retrieveAccount(@PathVariable long id) {
        Account account = accountService.findById(id);
        if (account == null)
            throw new ResourseNotFoundException(String.format("Account with id:%d not found", id));
        return account;
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable long id) {
        accountService.deleteById(id);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Object> createAccount(@RequestBody Account account) {
        Account savedAccount = accountService.save(account);
        //URL созданного ресурса
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedAccount.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<Object> updateAccount(@RequestBody Account account, @PathVariable long id) {
        Account accountExists = accountService.findById(id);
        if (accountExists == null)
            return ResponseEntity.notFound().build();
        account.setId(id);
        accountService.save(account);
        return ResponseEntity.noContent().build();
    }
}
