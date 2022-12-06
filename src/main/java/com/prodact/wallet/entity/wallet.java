package com.prodact.wallet.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "wallet")
public class wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name cann't be blank")
    @Size(min = 2,max = 30)
    private String name;
    @Size(min = 2,max = 30)
    private String accountNumber;
    @Size(max = 100)
    private String description;
    @Min(1)
    @Max(3)
    private Integer priority; //1=High; 2=Medium; 3=Low
    private Double currentBalance;
    @PrePersist
    public void setBalance(){ this.currentBalance = new Double(0); }
	
    @Override
	public String toString() {
		return "wallet [id=" + id + ", name=" + name + ", accountNumber=" + accountNumber + ", description="
				+ description + ", priority=" + priority + ", currentBalance=" + currentBalance + "]";
	}

	public wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public wallet(Long id, @NotBlank(message = "Name cann't be blank") @Size(min = 2, max = 30) String name,
			@Size(min = 2, max = 30) String accountNumber, @Size(max = 100) String description,
			@Min(1) @Max(3) Integer priority, Double currentBalance) {
		super();
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
		this.description = description;
		this.priority = priority;
		this.currentBalance = currentBalance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
}
