package imt.nord.europe.hibernate.model;

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

    //@JsonBackReference(value="transaction_as_sender")
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    @JoinColumn(name = "sender", referencedColumnName="account_id")
   AccountModel sender;

    //@JsonBackReference(value="transaction_as_receiver")
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    @JoinColumn(name = "receiver", referencedColumnName="account_id")
    AccountModel receiver;

    @NonNull
    @Column(name = "amount")
    Integer amountInCents;
}
