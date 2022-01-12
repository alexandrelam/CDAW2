package imt.nord.europe.hibernate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "region")
public class RegionModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long regionId;

    @NonNull
    @Column(name = "name")
    String name;

    @NonNull
    @Column(name = "temperature")
    Integer temperature;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "country_id")
    private CountryModel country;
}
