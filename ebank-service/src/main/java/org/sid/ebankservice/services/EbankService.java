package org.sid.ebankservice.services;

import lombok.AllArgsConstructor;
import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.enums.BankAccountType;
import org.sid.ebankservice.feign.CustomerRestClient;
import org.sid.ebankservice.models.Customer;
import org.sid.ebankservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author EL Mehdi EL MAIS
 */
@AllArgsConstructor
@Service
public class EbankService {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;
    public List<BankAccount> getAllBankAccounts() {
        //return bankAccountRepository.findByCustomerId(id);
        return bankAccountRepository.findAll();
    }
    public BankAccount getBankAccountById(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank account not exist"));
        Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
    public BankAccount saveBankAccount(BankAccount bankAccount) {

    try {
        Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        bankAccount.setType(Math.random() > 0.5 ? BankAccountType.CURRENT_ACCOUNT.toString(): BankAccountType.SAVING_ACCOUNT.toString());
        return bankAccountRepository.save(bankAccount);

    }catch(Exception e){
        throw new RuntimeException("Error: "+e);
    }

    }
}

