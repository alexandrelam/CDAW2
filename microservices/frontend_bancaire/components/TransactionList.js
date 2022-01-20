import TransactionCard from "./TransactionCard";
export default function TransactionList({ transactions }) {
  return (
    <div>
      {transactions.map((transaction) => {
        return (
          <TransactionCard
            key={transaction.transactionId}
            receiver={transaction.receiver}
          />
        );
      })}
    </div>
  );
}
