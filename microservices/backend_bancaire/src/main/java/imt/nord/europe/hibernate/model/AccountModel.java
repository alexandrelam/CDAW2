package imt.nord.europe.hibernate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "transaction_as_sender")
    @JsonBackReference
    @OneToMany(mappedBy = "sender")
    Set<TransactionModel> sender;

    @Column(name = "transaction_as_receiver")
    @JsonBackReference
    @OneToMany(mappedBy = "receiver")
    Set<TransactionModel> receiver;
}
