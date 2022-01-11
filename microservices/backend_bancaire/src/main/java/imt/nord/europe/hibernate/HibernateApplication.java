package imt.nord.europe.hibernate;

import imt.nord.europe.hibernate.model.*;
import imt.nord.europe.hibernate.repository.AccountRepository;
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
    public CommandLineRunner factory(AccountRepository accountRepository) {
        return (args) -> {
            accountRepository.save(new AccountModel("FR7620041010169876543210921", 0));
            accountRepository.save(new AccountModel("FR7630003035409876543210925", 100));
            accountRepository.save(new AccountModel("FR7630004028379876543210943", 10));
        };
    }
}
