package imt.nord.europe.hibernate.controller;

import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/account")
public class AccountController {
    @Autowired
    private final AccountService accountService;

    @Operation(summary = "List all accounts")
    @GetMapping
    public Iterable<AccountModel> findAll() {
        return accountService.findAll();
    }

    @Operation(summary = "Create a new account")
    @PostMapping
    public AccountModel create(@RequestBody AccountModel accountModel){
        return accountService.create(accountModel);
    }
}
