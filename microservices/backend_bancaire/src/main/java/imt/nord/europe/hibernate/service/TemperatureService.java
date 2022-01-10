package imt.nord.europe.hibernate.service;

import imt.nord.europe.hibernate.model.TemperatureModel;
import imt.nord.europe.hibernate.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;

@Service
public class TemperatureService {
    @Autowired
    private final TemperatureRepository temperatureRepository;

    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }
    public Iterable<TemperatureModel> findAll(){
        return temperatureRepository.findAll();
    }

    public Integer findTemperatureByCountry(String country) throws MultipartException {
        TemperatureModel countryModel = temperatureRepository.findFirstByCountry(country);
        return countryModel.getTemperature();
    }
}
