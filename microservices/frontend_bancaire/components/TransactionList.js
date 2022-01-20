import TransactionCard from "./TransactionCard";
import { useRouter } from "next/router";

export default function TransactionList({ iban, transactions }) {
  const router = useRouter();
  return (
    <div>
      <div>{iban}</div>
      <div>
        {transactions.map((transaction) => (
          <TransactionCard
            key={transaction.transactionId}
            iban={iban}
            receiver={transaction.receiver}
            sender={transaction.sender}
            amount={transaction.amountInCents}
          />
        ))}
      </div>
      <button onClick={() => router.push("/")}>Retour</button>
    </div>
  );
}
