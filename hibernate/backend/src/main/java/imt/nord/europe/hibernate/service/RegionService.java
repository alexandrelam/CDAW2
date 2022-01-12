package imt.nord.europe.hibernate.service;

import imt.nord.europe.hibernate.model.CountryModel;
import imt.nord.europe.hibernate.model.RegionModel;
import imt.nord.europe.hibernate.repository.CountryRepository;
import imt.nord.europe.hibernate.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegionService {
    @Autowired
    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;

    public Iterable<RegionModel> findAll(){
        return regionRepository.findAll();
    }

    public RegionModel findById(Long id){
        return regionRepository.findById(id).orElse(null);
    }

    public String delete(Long id){
        regionRepository.deleteById(id);
        return "region with id: " + id + " removed!";
    }

    public RegionModel create(RegionModel regionModel) {
        return regionRepository.save(regionModel);
    }

    public RegionModel update(RegionModel regionModel) {
        RegionModel existingRegion = regionRepository.findById(regionModel.getRegionId()).orElse(null);
        existingRegion.setName(regionModel.getName());
        existingRegion.setTemperature(regionModel.getTemperature());
        existingRegion.setCountry(regionModel.getCountry());
        return regionRepository.save(existingRegion);
    }

    public Iterable<RegionModel> findRegionsByCountry(Long id) {
        return regionRepository.findAllByCountry(countryRepository.findById(id).orElse(null));
    }
}
