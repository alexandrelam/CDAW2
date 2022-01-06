package imt.nord.europe.hibernate.controller;

import imt.nord.europe.hibernate.model.RegionModel;
import imt.nord.europe.hibernate.service.RegionService;
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
    public Optional<RegionModel> findById(@PathVariable Long id){
        return regionService.findById(id);
    }
}
