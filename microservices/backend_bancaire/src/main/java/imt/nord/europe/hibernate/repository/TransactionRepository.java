package imt.nord.europe.hibernate.repository;

import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.model.TransactionModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface TransactionRepository extends CrudRepository<TransactionModel, Long> {
    Iterable<TransactionModel> findBySenderOrReceiver(AccountModel accountModel1, AccountModel accountModel2);
}
