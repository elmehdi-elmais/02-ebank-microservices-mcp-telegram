package org.sid.ebankservice.services;

import lombok.AllArgsConstructor;
import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

/**
 * @author EL Mehdi EL MAIS
 */
@AllArgsConstructor
@Service
public class EbankService {
    private BankAccountRepository bankAccountRepository;

    public List<BankAccount> getAllBankAccounts() {
        //return bankAccountRepository.findByCustomerId(id);
        return bankAccountRepository.findAll();
    }
    public BankAccount getBankAccountById(String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank account not exist"))
                ;
    }
    public BankAccount saveBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);

    }
}

