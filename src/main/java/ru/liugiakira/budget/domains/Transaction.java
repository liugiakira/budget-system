package ru.liugiakira.budget.domains;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Транзакция
 * @author k.yakovleva
 */
@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue()
    private Long id;
    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_account", nullable = false)
    private Account account;
    @Column(name = "category_name")
    private String categoryName;
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @Column(name = "amount")
    private Double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
