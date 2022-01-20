import { useRouter } from "next/router";
import { useState, useEffect } from "react";
import TransactionList from "../components/TransactionList";

export default function Transactions() {
  const [transactions, setTransactions] = useState([]);
  const router = useRouter();
  const { pid } = router.query;
  useEffect(() => {
    fetch(`http://localhost:8084/api/v1/account/1/transactions`)
      .then((res) => res.json())
      .then((val) => {
        setTransactions(val);
        console.log(val);
      });
  }, []);

  return (
    <div>
      <TransactionList transactions={transactions} />
    </div>
  );
}
