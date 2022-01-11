package imt.nord.europe.hibernate.service;

import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {
    @Autowired
    private final AccountRepository accountRepository;

    public Iterable<AccountModel> findAll(){
        return accountRepository.findAll();
    }

    public AccountModel create(AccountModel accountModel) {
        return accountRepository.save(accountModel);
    }
}
