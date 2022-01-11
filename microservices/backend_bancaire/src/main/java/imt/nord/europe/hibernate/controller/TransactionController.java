package imt.nord.europe.hibernate.controller;

import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.model.TransactionModel;
import imt.nord.europe.hibernate.service.AccountService;
import imt.nord.europe.hibernate.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/transaction")
public class TransactionController {
    @Autowired
    private final TransactionService transactionService;

    @Operation(summary = "List all transactions")
    @GetMapping
    public Iterable<TransactionModel> findAll() {
        return transactionService.findAll();
    }
}
