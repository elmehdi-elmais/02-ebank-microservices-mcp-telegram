package org.sid.ebankservice;

import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.services.EbankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }
@Bean
    CommandLineRunner run(
            EbankService ebankService
    ){
        return args -> {
            LongStream.rangeClosed(1, 3).forEach(
                    customerId -> {
                        IntStream.rangeClosed(1, 5).forEach(i -> {
                            ebankService.saveBankAccount(
                                    new BankAccount(null, null, i * 10000, null, customerId, null));
                        });
                    });




            Stream<BankAccount> bankAccounts = Stream.<BankAccount>of(
                    new BankAccount(null, null,  10000, null, 1 ,null),
                    new BankAccount(null, null,  20000, null, 2 ,null),
                    new BankAccount(null, null,  30000, null, 3 ,null)
            );

            bankAccounts.forEach(bankAccount -> ebankService.saveBankAccount(bankAccount));
        };
    }
}
