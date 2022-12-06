package com.prodact.wallet.controller;

import com.prodact.wallet.entity.wallet;
import com.prodact.wallet.service.validationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import com.prodact.wallet.service.walletService;
@RestController
@RequestMapping("/wallet")
@CrossOrigin
public class walletController {
    @Autowired
    private walletService walletService;
    @Autowired
    private validationErrorService validationService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(walletService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(walletService.getById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody wallet wallet, BindingResult result){
        ResponseEntity<?> errors = validationService.validate(result);
        if(errors != null) return errors;
        wallet walletSaved = walletService.createOrUpdate(wallet);
        return new ResponseEntity<wallet>(walletSaved,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody wallet wallet, BindingResult result){
        ResponseEntity<?> errors = validationService.validate(result);
        if(errors != null) return errors;
        wallet.setId(id);
        wallet walletSaved = walletService.createOrUpdate(wallet);
        return new ResponseEntity<wallet>(walletSaved,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        walletService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
