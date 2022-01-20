import TransactionCard from "./TransactionCard";
import { useRouter } from "next/router";

export default function TransactionList({ iban, transactions }) {
  const router = useRouter();
  return (
    <div className="transaction-wrapper">
      <div className="title">{iban}</div>
      <div className="list-wrapper">
        <button className="button-return" onClick={() => router.push("/")}>
          Retour
        </button>
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
      </div>
    </div>
  );
}
