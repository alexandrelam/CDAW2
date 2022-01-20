import AccountForm from "../components/AccountForm";
import AccountList from "../components/AccountList";
import TransactionForm from "../components/TransactionForm";
import Image from "next/image";
export default function Home() {
  return (
    <div className="page">
      <div style={{ display: "flex", gap: "10px", alignItems: "center" }}>
        <Image
          src="/bnpparihaut.png"
          alt="bnpparihaut"
          width="100"
          height="100"
        />
        <h1> BNP Parihaut </h1>
      </div>
      <AccountList />
      <AccountForm />
      <TransactionForm />
    </div>
  );
}
