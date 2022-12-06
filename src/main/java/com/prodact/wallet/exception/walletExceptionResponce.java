package com.prodact.wallet.exception;



public class walletExceptionResponce {
    private String id;

	public walletExceptionResponce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public walletExceptionResponce(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "walletExceptionResponce [id=" + id + "]";
	}
}
