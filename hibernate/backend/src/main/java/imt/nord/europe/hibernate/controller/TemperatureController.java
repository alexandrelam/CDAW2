package imt.nord.europe.hibernate.controller;

import imt.nord.europe.hibernate.model.TemperatureModel;
import imt.nord.europe.hibernate.service.TemperatureService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/temperature")
public class TemperatureController {
    @Autowired
    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @Operation(summary = "List all countries and their respective temperature")
    @GetMapping
    public Iterable<TemperatureModel> findAll() {
        return temperatureService.findAll();
    }

    @Operation(summary = "Find the temperature of a country using its name")
    @GetMapping(path="/{country}")
    public Integer findTemperatureByCountry(@PathVariable String country){
        return temperatureService.findTemperatureByCountry(country);
    }
}
