package com.prodact.wallet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Min(1)
    @NotNull(message = "amount cann't be null")
    private Double amount;
    private String description;
    @Min(1)
    @Max(3)
    private int type;//1 for Income, 2 for expense, 3 for transfer
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date transactionDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_id",nullable = false)
    @JsonIgnore
    private wallet wallet;

    @PrePersist
    public void setTransactionDate(){ this.transactionDate = new Date(); }

	@Override
	public String toString() {
		return "transaction [id=" + id + ", amount=" + amount + ", description=" + description + ", type=" + type
				+ ", transactionDate=" + transactionDate + ", wallet=" + wallet + "]";
	}

	public transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public transaction(Long id, @Min(1) @NotNull(message = "amount cann't be null") Double amount, String description,
			@Min(1) @Max(3) int type, Date transactionDate, com.prodact.wallet.entity.wallet wallet) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.transactionDate = transactionDate;
		this.wallet = wallet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public wallet getWallet() {
		return wallet;
	}

	public void setWallet(wallet wallet) {
		this.wallet = wallet;
	}
}