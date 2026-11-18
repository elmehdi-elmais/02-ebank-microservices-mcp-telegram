package org.sid.ebankservice.controllers;

import lombok.AllArgsConstructor;
import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.services.EbankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author EL Mehdi EL MAIS
 */
@RestController
@AllArgsConstructor
public class EBankRestController {

    private EbankService ebankService;

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts() {
        return ebankService.getAllBankAccounts();
    }
    @GetMapping("/account/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return ebankService.getBankAccountById(id)
                ;
    }
    @PostMapping("account")
    public BankAccount saveBankAccount(@RequestBody BankAccount bankAccount) {
        return ebankService.saveBankAccount(bankAccount);

    }
}
