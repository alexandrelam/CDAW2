package imt.nord.europe.hibernate.service;

import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.model.TransactionModel;
import imt.nord.europe.hibernate.repository.AccountRepository;
import imt.nord.europe.hibernate.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;

    public Iterable<TransactionModel> findAll(){
        return transactionRepository.findAll();
    }

}
