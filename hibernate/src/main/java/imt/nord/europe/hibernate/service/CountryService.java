package imt.nord.europe.hibernate.service;

import imt.nord.europe.hibernate.model.CountryModel;
import imt.nord.europe.hibernate.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryService {
    @Autowired
    private final CountryRepository countryRepository;

    public Iterable<CountryModel> findAll(){
        return countryRepository.findAll();
    }

    public CountryModel findById(Long id){
        return countryRepository.findById(id).orElse(null);
    }

    public String delete(Long id){
        countryRepository.deleteById(id);
        return "country with id: " + id + " removed!";
    }

    public CountryModel create(CountryModel countryModel) {
        return countryRepository.save(countryModel);
    }

    public CountryModel update(CountryModel countryModel) {
        CountryModel existingRegion = countryRepository.findById(countryModel.getCountryId()).orElse(null);
        existingRegion.setName(countryModel.getName());
        existingRegion.setPresident(countryModel.getPresident());
        return countryRepository.save(existingRegion);
    }

    public Iterable<CountryModel> findAllWithRegionGreaterThanEqual(String minTemperature) {
        return countryRepository.findAllCountryWithRegionGreaterThanEqual(minTemperature);
    }
}
