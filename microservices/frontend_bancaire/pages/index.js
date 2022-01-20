import AccountForm from "../components/AccountForm";
import AccountList from "../components/AccountList";
import Test from "../components/Test";
export default function Home() {
  return (
    <div className="page">
      <h1>BNP Parihaut</h1>
      <AccountList />
      <AccountForm />
      <Test />
    </div>
  );
}
