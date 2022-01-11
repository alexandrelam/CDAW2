package imt.nord.europe.hibernate.repository;

import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.model.TransactionModel;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionModel, Long> {
}
