package imt.nord.europe.hibernate.controller;

import imt.nord.europe.hibernate.model.RegionModel;
import imt.nord.europe.hibernate.service.RegionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/region")
public class RegionController {
    @Autowired
    private final RegionService regionService;

    @Operation(summary = "list all regions")
    @GetMapping
    public Iterable<RegionModel> findAll() {
        return regionService.findAll();
    }

    @GetMapping("/{id}")
    public RegionModel findById(@PathVariable Long id){
        return regionService.findById(id);
    }

    @PostMapping
    public RegionModel create(@RequestBody RegionModel regionModel){
        return regionService.create(regionModel);
    }

    @PutMapping
    public RegionModel update(@RequestBody RegionModel regionModel){
        return regionService.update(regionModel);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {return regionService.delete(id);}
}
