import AccountForm from "../components/AccountForm";
import AccountList from "../components/AccountList";
import TransactionForm from "../components/TransactionForm";
export default function Home() {
  return (
    <div className="page">
      <h1>BNP Parihaut</h1>
      <AccountList />
      <AccountForm />
      <TransactionForm />
    </div>
  );
}
