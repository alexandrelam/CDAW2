package imt.nord.europe.hibernate.model;

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

    @Column(name = "comment")
    @JsonManagedReference
    @OneToMany(mappedBy = "country")
    Set<RegionModel> regions;
}
