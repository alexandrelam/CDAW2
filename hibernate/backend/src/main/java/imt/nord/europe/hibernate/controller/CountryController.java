package imt.nord.europe.hibernate.controller;

import imt.nord.europe.hibernate.model.CountryModel;
import imt.nord.europe.hibernate.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1")
public class CountryController {
    @Autowired
    private final CountryService countryService;

    @Operation(summary = "List all countries and their regions")
    @GetMapping("/country")
    public Iterable<CountryModel> findAll() {
        return countryService.findAll();
    }

    @Operation(summary = "List all countries whose regions have a minimum temperature of {minTemperature}")
    @GetMapping("/region/minTemp/{minTemperature}/country")
    public Iterable<CountryModel> findAllWithRegionGreaterThanEqual(@PathVariable String minTemperature) {
        return countryService.findAllWithRegionGreaterThanEqual(minTemperature);
    }

    @Operation(summary = "Show a country and its region")
    @GetMapping("/country/{id}")
    public CountryModel findById(@PathVariable Long id) {
        return countryService.findById(id);
    }

    @Operation(summary = "Create a new country")
    @PostMapping("/country")
    public CountryModel create(@RequestBody CountryModel countryModel){
        return countryService.create(countryModel);
    }

    @Operation(summary = "Update a country")
    @PutMapping("/country")
    public CountryModel update(@RequestBody CountryModel countryModel){
        return countryService.update(countryModel);
    }

    @Operation(summary = "Delete an existing country")
    @DeleteMapping("/country/{id}")
    public String delete(@PathVariable Long id) {return countryService.delete(id);}
}
