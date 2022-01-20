import Transactions from "../pages/[pid]";

export default function TransactionList({ transactions }) {
  return (
    <div>
      {transactions.map((transactions) => {
        return <TransactionCard receiver={receiver} />;
      })}
    </div>
  );
}
