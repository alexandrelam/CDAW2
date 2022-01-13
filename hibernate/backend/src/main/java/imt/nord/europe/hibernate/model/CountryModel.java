package imt.nord.europe.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "country")
public class CountryModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long countryId;

    @NonNull
    @Column(name = "name")
    String name;

    @NonNull
    @Column(name = "president")
    String president;

    @NonNull
    @Column(name = "flag_url")
    String flag_url;

    @Column(name = "country")
    @JsonIgnore
    @OneToMany(mappedBy = "country")
    Set<RegionModel> regions;
}
