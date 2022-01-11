package imt.nord.europe.hibernate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "transaction")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @ManyToOne
    @NonNull
    @JsonBackReference
    @JoinColumn(name = "sender", referencedColumnName="account_id")
   AccountModel sender;

    @ManyToOne
    @NonNull
    @JsonBackReference
    @JoinColumn(name = "receiver", referencedColumnName="account_id")
    AccountModel receiver;

    @NonNull
    @Column(name = "amount")
    Integer amountInCents;
}