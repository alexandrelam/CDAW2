package imt.nord.europe.hibernate.service;

import imt.nord.europe.hibernate.model.CountryModel;
import imt.nord.europe.hibernate.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService {
    @Autowired
    private final CountryRepository countryRepository;

    public Iterable<CountryModel> findAll(){
        return countryRepository.findAll();
    }

    public Optional<CountryModel> findById(Long id){
        return countryRepository.findById(id);
    }
}
