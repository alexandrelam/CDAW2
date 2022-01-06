package imt.nord.europe.hibernate.controller;

import imt.nord.europe.hibernate.model.CountryModel;
import imt.nord.europe.hibernate.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/country")
public class CountryController {
    @Autowired
    private final CountryService countryService;

    @Operation(summary = "List all countries and their regions")
    @GetMapping
    public Iterable<CountryModel> findAll() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CountryModel> findById(@PathVariable Long id){
        return countryService.findById(id);
    }
}
