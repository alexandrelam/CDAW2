package imt.nord.europe.hibernate.controller;

import imt.nord.europe.hibernate.model.CountryModel;
import imt.nord.europe.hibernate.model.RegionModel;
import imt.nord.europe.hibernate.service.RegionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1")
public class RegionController {
    @Autowired
    private final RegionService regionService;

    @Operation(summary = "List all regions")
    @GetMapping("/region")
    public Iterable<RegionModel> findAll() {
        return regionService.findAll();
    }

    @Operation(summary = "Show a region")
    @GetMapping("/region/{id}")
    public RegionModel findById(@PathVariable Long id){
        return regionService.findById(id);
    }


    @Operation(summary = "List all regions from a country")
    @GetMapping("/country/{id}/region")
    public Iterable<RegionModel> findRegionsByCountry(@PathVariable Long id) {
        return regionService.findRegionsByCountry(id);
    }

    @Operation(summary = "Create a new region")
    @PostMapping("/region")
    public RegionModel create(@RequestBody RegionModel regionModel){
        return regionService.create(regionModel);
    }

    @Operation(summary = "Update a region")
    @PutMapping
    public RegionModel update(@RequestBody RegionModel regionModel){
        return regionService.update(regionModel);
    }

    @Operation(summary = "Delete a region")
    @DeleteMapping("region/{id}")
    public String delete(@PathVariable Long id) {return regionService.delete(id);}
}
