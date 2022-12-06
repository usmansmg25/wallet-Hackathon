package com.prodact.wallet.Repository;

import com.prodact.wallet.entity.transaction;
import com.prodact.wallet.entity.wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<transaction,Long> {
    List<transaction> findByWallet(wallet wallet);
}
