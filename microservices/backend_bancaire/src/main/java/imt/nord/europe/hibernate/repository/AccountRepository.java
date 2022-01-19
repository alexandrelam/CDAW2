package imt.nord.europe.hibernate.repository;

import imt.nord.europe.hibernate.model.AccountModel;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountModel, Long> {
    AccountModel findFirstByIban(String iban);
}
