package com.prodact.wallet.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodact.wallet.entity.wallet;

import java.util.List;
import java.util.Optional;

	
	@Repository
	public interface walletRepo extends JpaRepository<wallet,Long> {
	    List<wallet> findAllByOrderByPriority();
	}

	
	

	

	
	

