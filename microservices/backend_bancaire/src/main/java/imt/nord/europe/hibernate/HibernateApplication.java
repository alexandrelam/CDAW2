package imt.nord.europe.hibernate;

import imt.nord.europe.hibernate.model.*;
import imt.nord.europe.hibernate.repository.AccountRepository;
import imt.nord.europe.hibernate.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner factory(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        return (args) -> {
            AccountModel accountA = new AccountModel("FR7620041010169876543210921", 0);
            AccountModel accountB = new AccountModel("FR7630003035409876543210925", 100);
            AccountModel accountC = new AccountModel("FR7630004028379876543210943", 100);

            accountRepository.save(accountA);
            accountRepository.save(accountB);
            accountRepository.save(accountC);

            transactionRepository.save(new TransactionModel(accountA, accountB, 2300));
            transactionRepository.save(new TransactionModel(accountB, accountA, 1000));
            transactionRepository.save(new TransactionModel(accountC, accountA, 1000));

        };
    }
}
