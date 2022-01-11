package imt.nord.europe.hibernate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "accountId")
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

    //@JsonManagedReference(value="transaction_as_sender")
    @Column(name = "transaction_as_sender")
    @OneToMany(mappedBy = "sender")
    Set<TransactionModel> sender;

    //@JsonManagedReference(value="transaction_as_receiver")
    @Column(name = "transaction_as_receiver")
    @OneToMany(mappedBy = "receiver")
    Set<TransactionModel> receiver;
}
