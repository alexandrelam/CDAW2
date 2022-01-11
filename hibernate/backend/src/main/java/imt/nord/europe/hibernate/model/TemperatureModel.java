package imt.nord.europe.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "temperature")
public class TemperatureModel {
    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TemperatureModel() {
    }

    public TemperatureModel(String country, Integer temperature) {
        this.country = country;
        this.temperature = temperature;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "country")
    String country;


    @Column(name = "temperature")
    Integer temperature;
}
