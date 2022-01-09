package imt.nord.europe.hibernate.controller;

import imt.nord.europe.hibernate.model.CountryModel;
import imt.nord.europe.hibernate.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("minTemp/{minTemperature}")
    public Iterable<CountryModel> findAllWithRegionGreaterThanEqual(@PathVariable String minTemperature) {
        return countryService.findAllWithRegionGreaterThanEqual(minTemperature);
    }

    @GetMapping("/{id}")
    public CountryModel findById(@PathVariable Long id) {
        return countryService.findById(id);
    }

    @PostMapping
    public CountryModel create(@RequestBody CountryModel countryModel){
        return countryService.create(countryModel);
    }

    @PutMapping
    public CountryModel update(@RequestBody CountryModel countryModel){
        return countryService.update(countryModel);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {return countryService.delete(id);}
}
