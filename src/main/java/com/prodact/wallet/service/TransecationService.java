
package com.prodact.wallet.service;

import com.prodact.wallet.Repository.TransactionRepository;
import com.prodact.wallet.Repository.walletRepo;
import com.prodact.wallet.entity.transaction;
import com.prodact.wallet.entity.wallet;
import com.prodact.wallet.exception.walletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransecationService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private walletRepo walletRepo;

	public List<transaction> getAll(Long walletId) {
		Optional<wallet> wallet = walletRepo.findById(walletId);
		if (wallet.isPresent()) {
			return transactionRepository.findByWallet(wallet.get());
		}
		return null;
	}

	public transaction getById(Long wallet_id, Long id) {
		Optional<wallet> wallet = walletRepo.findById(wallet_id);
		if (wallet.isPresent()) {
			Optional<transaction> transaction = transactionRepository.findById(id);
			if (transaction.isPresent()) {
				return transaction.get();
			}
		}
		throw new walletException("Transaction with " + id + " does not exists!");
	}

	public transaction createOrUpdate(Long walletId, transaction transaction) {
		Optional<wallet> wallet = walletRepo.findById(walletId);
		if (wallet.isPresent()) {
			transaction.setWallet(wallet.get());
			transactionRepository.save(transaction);
			return transaction;
		}
		return null;
	}

	public boolean delete(Long wallet_id, Long id) {
		Optional<wallet> wallet = walletRepo.findById(wallet_id);
		if (wallet.isPresent()) {
			Optional<transaction> transaction = transactionRepository.findById(id);
			if (transaction.isPresent()) {
				transactionRepository.delete(transaction.get());
				return true;
			}
		}
		throw new walletException("Transaction with " + id + " does not exists!");
	}
}
