package imt.nord.europe.hibernate.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "account")
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", unique = true, nullable = false)
    private Long accountId;

    @NonNull
    @Column(name = "iban")
    String iban;

    @NonNull
    @Column(name = "amount")
    Integer amountInCents;

    @JsonIgnore
    @Column(name = "transaction_as_sender")
    @OneToMany(mappedBy = "sender")
    Set<TransactionModel> sender;

    @JsonIgnore
    @Column(name = "transaction_as_receiver")
    @OneToMany(mappedBy = "receiver")
    Set<TransactionModel> receiver;
}
