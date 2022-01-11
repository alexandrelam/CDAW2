package imt.nord.europe.hibernate.controller;

import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.model.TransactionModel;
import imt.nord.europe.hibernate.service.AccountService;
import imt.nord.europe.hibernate.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1")
public class TransactionController {
    @Autowired
    private final TransactionService transactionService;

    @Operation(summary = "List all transactions")
    @GetMapping("/transactions")
    public Iterable<TransactionModel> findAll() {
        return transactionService.findAll();
    }


    @Operation(summary = "List all transactions of a particular account")
    @GetMapping("account/{id}/transactions")
    public Iterable<TransactionModel> transaction(@PathVariable Long id) {
        return transactionService.findByAccount(id);
    }
}
