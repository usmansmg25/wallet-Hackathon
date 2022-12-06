package com.prodact.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodact.wallet.Repository.walletRepo;
import com.prodact.wallet.entity.wallet;
import com.prodact.wallet.exception.walletException;

import java.util.List;
import java.util.Optional;

@Service
public class walletService {
    @Autowired
    private walletRepo walletRepository;
    public List<wallet> getAll(){
        return walletRepository.findAllByOrderByPriority();
    }
    public wallet getById(Long id){
        Optional<wallet> wallet = walletRepository.findById(id);
        if(wallet.isPresent()){
            return wallet.get();
        }
        throw new walletException("wallet with "+id+" does not exists!");
    }
    public wallet createOrUpdate(wallet wallet){
        if(wallet.getId()==null){
            walletRepository.save(wallet);
        }else {
            walletRepository.save(wallet);
        }
        return wallet;
    }
    public boolean delete(Long id){
        Optional<wallet> wallet = walletRepository.findById(id);
        if(wallet.isPresent()){
            walletRepository.delete(wallet.get());
            return true;
        }
        throw new walletException("wallet with "+id+" does not exists!");
    }
}
